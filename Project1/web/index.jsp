<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="project.view.MessageConstants" %>
<%@ page import="project.view.View" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<html>
<style>
  html {
    font-family: "Courier New", Courier, monospace;
  }

  div {
    float: left; /*Задаем обтекание*/
    line-height: 20px; /*Высота строки +  верт. центрирования текста*/
    font-size: 20px;

    width: 320px; /*Фиксируем ширину блока*/
    margin-right: 30px;
  }

  ul {
    display: block;
    font-size: 22px;
    margin: 15px;
    list-style: none;
    padding: 10px;
    border: 3px solid #000000; /* Белая рамка */
    border-radius: 15px;
  }

  li {
    padding: 10px 0;
  }

  button {
    text-align: center;
  }

  .addDisc {
    margin: 20px;
  }

  .songsByRange {
    text-align: left;
  }
</style>
<head>
  <title></title>
</head>
<body>
<c:if test="${not empty errorMessage}">
  <script>
      alert('${errorMessage}');
  </script>
</c:if>

<div>
  <label><%=View.bundle.getString(MessageConstants.FULL_DURATION)%>: <c:out value="${fullDuration}"/></label>
  <c:forEach items="${discs}" var="song">
    <div class="song">
      <ul>
        <li><%=View.bundle.getString(MessageConstants.NAME)%>: <c:out value="${song.getName()}"/></li>
        <li><%=View.bundle.getString(MessageConstants.AUTHOR)%>: <c:out value="${song.getAuthor()}"/></li>
        <li><%=View.bundle.getString(MessageConstants.GENRE)%>: <c:out value="${song.getStyle()}"/></li>
        <li><%=View.bundle.getString(MessageConstants.DURATION)%>: <c:out
                value="${song.getDuration()}"/><%=View.bundle.getString(MessageConstants.SECONDS)%>
        </li>
      </ul>
    </div>
  </c:forEach>
</div>
<form method="post">
  <div class="disc">
    <label><%=View.bundle.getString(MessageConstants.ADD_SONG)%>
    </label>
    <button class="btnAddSong" type="button"><%=View.bundle.getString(MessageConstants.ADD_BUTTON)%>
      <button class="btnRemoveSong" type="button"
              style="margin-left: 5px"><%=View.bundle.getString(MessageConstants.DELETE)%>
      </button>
      <div class="addDisc" style="display: none">
        <label><%=View.bundle.getString(MessageConstants.NAME)%>: <input type="text" name="name" value="">
        </label>
        <br><br>
        <label><%=View.bundle.getString(MessageConstants.AUTHOR)%>: <input type="text" name="author" value="">
        </label> <br><br>
        <label><%=View.bundle.getString(MessageConstants.GENRE)%>: <select name="genre">
          <c:forEach items="${genre}" var="style">
            <option><c:out value="${style.getStyle()}"/></option>
          </c:forEach>
        </select>
        </label>
        <br><br>
        <label><%=View.bundle.getString(MessageConstants.DURATION)%>: <input type="number" name="duration"
                                                                             value="">
        </label> <br><br>
        <button type="submit"><%=View.bundle.getString(MessageConstants.SUBMIT)%>
        </button>
        <br>
      </div>
      <div class="removeDisc" style="display: none;">
        <label>Выберете, что удалить</label>
        <select name="deleteSongName">
          <option>Название</option>
          <c:forEach items="${discs}" var="song">
            <option><c:out value="${song.getName()}"/></option>
          </c:forEach>
        </select>
        <select name="deleteSongAuthor">
          <option>Автор</option>
          <c:forEach items="${discs}" var="song">
            <option><c:out value="${song.getAuthor()}"/></option>
          </c:forEach>
        </select>
        <button type="submit"><%=View.bundle.getString(MessageConstants.SUBMIT)%>
        </button>
      </div>
  </div>
  <div class="songsByRange">
    <label><%=View.bundle.getString(MessageConstants.ADD_RANGE)%>: </label><br>
    <label><%=View.bundle.getString(MessageConstants.FROM)%>
      <input type="number" name="minRange" value="${minRange}"> </label>
    <br>
    <label><%=View.bundle.getString(MessageConstants.TO)%>
      <input type="number" name="maxRange" value="${maxRange}">
    </label>
    <br>
    <button type="submit"><%=View.bundle.getString(MessageConstants.SUBMIT)%>
    </button>
    <button type="button" class="btnRange"><%=View.bundle.getString(MessageConstants.SHOW)%>
    </button>
    <div class="songRange" style="display: none">
      <c:out value="${songsByRangeError}"/>
      <c:forEach items="${songsByRange}" var="song">
        <ul>
          <li><%=View.bundle.getString(MessageConstants.NAME)%>: <c:out value="${song.getName()}"/></li>
          <li><%=View.bundle.getString(MessageConstants.AUTHOR)%>: <c:out value="${song.getAuthor()}"/></li>
          <li><%=View.bundle.getString(MessageConstants.GENRE)%>: <c:out value="${song.getStyle()}"/></li>
          <li><%=View.bundle.getString(MessageConstants.DURATION)%>: <c:out
                  value="${song.getDuration()}"/><%=View.bundle.getString(MessageConstants.SECONDS)%>
          </li>
        </ul>
      </c:forEach>
      <button type="button" class="btnRange"><%=View.bundle.getString(MessageConstants.HIDE)%>
      </button>
    </div>
  </div>
  <div>
    <div class="songsByStyle">
      <label><%=View.bundle.getString(MessageConstants.SONGS_BY_STYLE)%>
</label>
<button class="btnSortStyle" type="button"><%=View.bundle.getString(MessageConstants.SHOW)%>
</button>
<div class="songSortStyle" style="display: none">
  <c:forEach items="${songsSortByStyle}" var="song">
    <ul>
      <li><%=View.bundle.getString(MessageConstants.NAME)%>: <c:out value="${song.getName()}"/></li>
      <li><%=View.bundle.getString(MessageConstants.AUTHOR)%>: <c:out
              value="${song.getAuthor()}"/></li>
      <li><%=View.bundle.getString(MessageConstants.GENRE)%>: <c:out value="${song.getStyle()}"/></li>
      <li><%=View.bundle.getString(MessageConstants.DURATION)%>: <c:out
              value="${song.getDuration()}"/><%=View.bundle.getString(MessageConstants.SECONDS)%>
      </li>
    </ul>
  </c:forEach>
  <button type="reset" class="btnSortStyle"
          onclick="removeSongRange()"><%=View.bundle.getString(MessageConstants.HIDE)%>
  </button>
</div>
</div>
</div>
<div>
  <label><%=View.bundle.getString(MessageConstants.GENRE)%>: </label>
  <select name="style">
    <c:forEach items="${genre}" var="style">
      <option><c:out value="${style.getStyle()}"/></option>
    </c:forEach>
  </select>
  <button type="submit"><%=View.bundle.getString(MessageConstants.SUBMIT)%>
  </button>
  <button type="button" class="btnStyle"><%=View.bundle.getString(MessageConstants.SHOW)%>
  </button>
  <div class="songStyle" id="songStyle" style="display: none">
    <p><%=View.bundle.getString(MessageConstants.GENRE)%>: <%=request.getParameter("style")%></p>
    <c:out value="${songsByStyleError}"/>
    <c:forEach items="${songsByStyle}" var="song">
      <ul>
        <li><%=View.bundle.getString(MessageConstants.NAME)%>: <c:out value="${song.getName()}"/></li>
        <li><%=View.bundle.getString(MessageConstants.AUTHOR)%>: <c:out value="${song.getAuthor()}"/></li>
        <li><%=View.bundle.getString(MessageConstants.GENRE)%>: <c:out value="${song.getStyle()}"/></li>
        <li><%=View.bundle.getString(MessageConstants.DURATION)%>: <c:out value="${song.getDuration()}"/>s
        </li>
      </ul>
    </c:forEach>
    <button class="btnStyle"><%=View.bundle.getString(MessageConstants.HIDE)%>
    </button>
  </div>
</div>
</form>
</body>
</html>

<script>
    $('.btnAddSong').click(function () {
        $(".addDisc").fadeToggle(100);
    });

    $('.btnRemoveSong').click(function () {
        $(".removeDisc").fadeToggle(100);
    });

    $('.btnSortStyle').click(function () {
        $(".songSortStyle").fadeToggle(100);
    });

    $('.btnStyle').click(function () {
        $(".songStyle").fadeToggle(100);
    });

    $('.btnRange').click(function () {
        $(".songRange").fadeToggle(100);
    });


    function removeSongRange() {
        document.getElementById("songRange").remove();
    }

</script>