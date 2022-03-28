$(document).ready(function() {
	$('#view').DataTable({
		searching: false,
		paging: false,
		info: false
	});;

	$('.clear-btn').on('click', function() {
		$('.form-inp').val("");
	});


	$(".reject-msg").hide();

	$(".select-status").on("change", function() {
		if (this.value.trim() == "Rejected") {
			$(".reject-msg").show();
		} else {
			$(".reject-msg").hide();
		}
	});
});

//reset data for duty time and day.
const resetData = { "time": "", "day": "" };
//append multiple child
Element.prototype.addChildren = function (children) {
	for (var x of children) {
		this.appendChild(x);
	}
};
//validation message duration
const messageTime = setTimeout(message, 2000);
//duration func
function message() {
	$('.message-field').fadeOut(350, function() {
		$(this).remove();
	});
}
//document ready
$(function () {
	//pre checking selected doctor date and time.
	if($('#dutytime')[0]!=null && $('#selector-inp')[0] != null){
		preLoadingDT();
	}
	//advance check the focus for selector box
	$('.selectors').focusout(function () {
		$(this).slideUp(350, function () {
			$('.select-ico').removeClass('active');
		});
		$(this).removeClass("active");
	});
	$('.selectors').focusin(function () {
		$(this).slideDown(350, function () {
			this.focus();
		});
		$(this).addClass("active");
	});
	//time selection
	$(".time").on("input", function(e) {
    e.preventDefault();
		applySelectedTime();
	});
	//day selection
	$(".select-ico").on('click', function(e) {
		e.preventDefault();
		var check = $(this).hasClass('active');
		!check ? $('.selectors').focusin() : $('.selectors').focusout();
		$(this).toggleClass('active');
	});
	//select days click event
	$(".day-selector .days").on("click", function(e) {
		e.stopPropagation();
		if (!$(this).hasClass('selected')) {
			var item = createSelected(this);
			$('.selection').append($(item));
			$(this).addClass('selected');
			$('.selection')[0].addChildren(setDayOrder());
			applySelectedDay();
			$('.item').each(function () {
				if (this.innerHTML == item.innerHTML) {
					$(this).addClass('animate');
				}
			});
		} else {
			$("#_" + this.innerHTML).fadeOut(350, function () {
				$(this).remove();
			});
			$(this).removeClass('selected');
		}
	});
	//Back button onclick
	$('.back-btn').on('click',function(){
		window.history.back();
	});
	//Reset button onclick
	$('.reset-btn').on('click',function(){
		$('#form')[0].reset();
		if (this.dataset['reset'] == 1) {
			resetDoctorData();
		}
	});
});
//reset doctor data
function resetDoctorData() {
	$('#dutytime').attr("value", resetData.time);
	$('#selector-inp').attr("value", resetData.day);
	$('.selection').children().each(function () {
		this.remove();
	});
	$('.days').each(function () {
		$(this).removeClass('selected');
	});
	preLoadingDT();
}
//pre loading doctor duty day and time
function preLoadingDT(){
	var time = $('#dutytime')[0];
	var times = stringTokenizer(time.value,'-');
	var day = $('#selector-inp')[0];
  var days = stringTokenizer(day.value, ',');
  resetData.time = time.value;
  resetData.day = day.value;
	if(times.length){
		$('.time').each(function(){
			if($(this).data('time') == 'start'){
				this.value = times[0].trim();
			}
			if($(this).data('time') == 'end'){
				this.value = times[1].trim();
			}
		});
	}
	if(days.length){
		for(var day of days){
			var x = document.createElement('span');
			x.innerHTML = day.trim();
			var item = createSelected(x);
			$('.selection').append($(item));
			$('.days').each(function(){
				if($(this).data('day') == day.trim()){
					$(this).addClass("selected");
				}
			});
		}
		$('.selection')[0].addChildren(setDayOrder());
		applySelectedDay();
	}
}
//String Tokenizer
function stringTokenizer(str,pattern){
	var strs = [];
	if(str.length > 0){
		strs = str.split(pattern);
	}
	return strs;
}
//create and append day selector
function createSelected(selector) {
	var item = document.createElement('div');
	$(item).addClass("days item selected lf clearfix");
	item.id = "_" + selector.innerHTML.trim();
	item.title = "Remove from selection";
	var daywrp = document.createElement('span');
	$(daywrp).addClass('days-wrp lf');
	daywrp.innerHTML = selector.innerHTML;
	var cls = document.createElement('span');
	$(cls).addClass("unselect-day fa-usage close-ico rg");
	$(item).on('click', function(e) {
		e.stopPropagation();
		var day = $(this).children().first().text();
		$(".day-selector").children().each(function() {
			var cmd = $(this).data('day');
			if (cmd == day) {
				$(this).removeClass('selected');
			}
		});
		$(this).fadeOut(350, function() {
			$(this).remove();
			applySelectedDay();
		});
	});
	item.append(daywrp);
	item.append(cls);
	return item;
}
//apply selected time
function applySelectedTime() {
	var time = $('#dutytime')[0];
	var selected = "";
	$('.time').each(function() {
		var cmd = $(this).data('time');
		if (cmd == "start") {
			selected = $(this).val() + " - ";
		}
		if (cmd == "end") {
			selected += $(this).val();
		}
	});
	console.log("Hello : " + selected);
	$(time).attr("value", selected);
}
//apply selected day
function applySelectedDay() {
	var selectorinput = $('#selector-inp')[0];
	var selected = "";
	$('.days.item').each(function () {
		selected += $(this).text() + ", ";
	});
	selected = selected.trim();
	selected = selected.slice(0, selected.length - 1);
	$(selectorinput).attr("value", selected);
}
//order days
function setDayOrder() {
	const days = {
		"sunday":0,
		"monday": 1,
		"tuesday": 2,
		"wendesday": 3,
		"thursday": 4,
		"friday": 5,
		"saturday": 6,
	};
	let selected = [];
	$('.days.item').each(function () {
		selected.push({ "day": $(this).text().toLowerCase().trim() });
		$(this).remove();
	});
	selected.sort(function(a, b) {
		let first = a.day;
		let second = b.day;
		return days[first] > days[second] ? 1 : days[first] < days[second] ? -1 : 0;
	});
	var sorted = [];
	var child;
	for (var x of selected) {
		child = document.createElement('span');
		child.innerHTML = x.day.charAt(0).toUpperCase()+x.day.slice(1);
		sorted.push(createSelected(child));
	}
	return sorted;
}
