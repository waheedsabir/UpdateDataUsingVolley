<?php

require "config.php";
 $id  = $_GET['id'];






$sql  = "DELETE FROM health WHERE id ='$id' ";

if(mysqli_query($conn, $sql)){
	echo "Deleted";
}
else {
	echo "<p>No Delete</p>";
}
?>