<?php 
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 
 $id  = $_GET['id'];
 
 require_once('config.php');
 
 $sql = "SELECT * FROM health WHERE id='".$id."'";
 
 $r = mysqli_query($conn,$sql);
 $result = array();
 
 while ($res = mysqli_fetch_array($r)){
	 
	 
 
 
 array_push($result,array(
"id"=>$res['id'],
 "title"=>$res['title'],
 
 "detail"=>$res['detail']
 
 
 
 )
 );  
	 
	
 }

 
/*  echo json_encode(array("result"=>$result));  */


//remove th blackslashes
echo json_encode($result, JSON_UNESCAPED_SLASHES);
 
 mysqli_close($conn);
 
 }