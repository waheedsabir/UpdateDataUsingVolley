<?php

require "config.php";
 $id  = $_GET['id'];



$title= $_POST["title"];
$detail= $_POST["detail"];



$sql  = "UPDATE health SET title='$title' , detail = '$detail'  WHERE id ='$id' ";

if(mysqli_query($conn, $sql)){
	echo "Update";
}
else {
	echo "<p>Not Connected</p>";
}
?>