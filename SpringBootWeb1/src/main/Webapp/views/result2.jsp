<%@ page language="java"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>DataViewPage</title>
    <link rel="stylesheet" href="style.css" />
    <style>
      body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #74ebd5, #9face6);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }

      .card {
        background: #fff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.2);
        width: 350px;
        text-align: center;
      }

      .card h1 {
        margin-bottom: 20px;
        color: #333;
      }

      .details {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
      }

      .details td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
        text-align: left;
        font-size: 16px;
      }

      .details td:first-child {
        font-weight: bold;
        color: #444;
        width: 120px;
      }
    </style>
  </head>
  <body>
    <div class="card">
      <h1>Welcome to Alien</h1>

      <table class="details">
        <tr>
          <td>Aid:</td>
          <td>${alien.aid}</td>
        </tr>
        <tr>
          <td>Aname:</td>
          <td>${alien.aname}</td>
        </tr>
        <tr>
          <td>CourseName:</td>
          <td><p>Welcome to the {course} world</p></td>
        </tr>
      </table>
    </div>
  </body>
</html>
