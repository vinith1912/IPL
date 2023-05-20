<?php
session_start();
$name = $_POST['name'];
$email = $_POST['email'];
$gender =$_POST['gender'];
$mobile = $_POST['mobile'];
$con = mysqli_connect("localhost:3306","root","","users"); if($con->connect_error)
{
echo "$con->connect_error";
die("Connection Failed :".$con->connect_error);
}
else
{
$s = "insert into user(name,email,mobile,gender) values ('$name','$email','$mobile','$gender')";

$result = mysqli_query($con,$s);

 


!!<h4>";


}
 
if($result)
echo "<br><h4>Form data stored in the database successfully

else
echo"<h4>Error storing data in the database</h4>";
 
}
?>
