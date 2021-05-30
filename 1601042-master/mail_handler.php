<?php
	if(isset($_POST['submit'])){
		$name=$_POST['Name'];
		$email=$_POST['Email'];
		$Subject=$_POST['Subject'];
		$msg=$_POST['Service-Type'];

		$to='gavingrant691@gmail.com'; // Receiver Email ID, Replace with your email ID
		$subject='Form Submission';
		$message="Name :".$name."\n"."Phone :".$Subject."\n"."Wrote the following :"."\n\n".$msg;
		$headers="From: ".$email;

		if(mail($to, $subject, $message, $headers)){
			echo "<h1>Sent Successfully! Thank you"." ".$name.", We will contact you shortly!</h1>";
		}
		else{
			echo "Something went wrong!";
		}
	}
?>