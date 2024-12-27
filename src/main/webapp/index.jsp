<html>
<style>
.content {
  position: absolute;
  left: 50%;
  top: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  color:white;
  background-color:black;
  background-blend-mode:lighten;
  padding-top: 20px;
      padding-right: 20px;
      padding-bottom: 20px;
      padding-left: 20px;

}
.textcontent{
 padding-bottom: 15px;
 font-size:2.5em;
}
body{
background-image: url("Images/bgimage.jpg");
background-blend-mode:lighten;
}
</style>
<body >
<div class = "content">
    <div class = "textcontent">
            WebCrawler
</div>
<form action="WebCrawler"> <!-- whenever we submit this form this will redirect to the search servlet
(i.e. Search.java) -->
    <input type = "text" name="url"></input>
    <button type = "submit">Crawl!</button>
</form>
</div>
</body>
</html>