<!-- Menu -->
<a href="sellbooks" class="menu">Sell Books</a>
<a href="books" class="menu">Books</a>
<form action="<%=request.getContextPath()%>/logout" method="POST">
  <input type="submit" value="Logout" class="logout" /> <input
    type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>