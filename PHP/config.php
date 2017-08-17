<?php

//TODO
$dbname = "concepts_db";
$username = "waheedsabir"; 
$password = "03034486786";
$server= "localhost";

// to contact the database 


$conn = mysqli_connect($server,$username, $password,$dbname); 

if ($conn){
	
	
	$response["state"] ="1";
	$response["message"] ="Data submit";
	// echo json_encode ($response);
	
}
else
{
	
	echo "<p>Not Connected </p>";
}






?>