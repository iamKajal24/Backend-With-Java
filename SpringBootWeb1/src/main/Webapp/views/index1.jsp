<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Kajal Calculator</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div class="container">
      <h2>Kajal Calculator</h2>

      <form th:action="@{/addAlien}" method="post">
        <label for="aid">Enter aid :</label>
        <input type="text" id="aid" name="aid" /><br /><br />

        <label for="aname">Enter aname :</label>
        <input type="text" id="aname" name="aname" /><br /><br />

        <input type="submit" value="Submit" />
      </form>
    </div>
  </body>
</html>
