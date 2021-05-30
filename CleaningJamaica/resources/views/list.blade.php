<!doctype html>
<html lang="en">
  <head>
  	<title>Customer Appointment Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="Table.css">

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Booking Information</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-bordered table-dark table-hover">
						  <thead>
						    <tr>
				
						      <th>Customer's Name</th>
						      <th>Customer's Address</address></th>
							  <th>Appointment Date</address></th>
						      <th>Customer's Phone Number</th>
							  <th>Option/Price Selected</th>
						    </tr>
						  </thead>
						  <tbody>
						  @foreach($bookingsystems as $bookingsystem)
<tr>
    <td> {{$bookingsystem['name']}}</td>
    <td> {{$bookingsystem['address']}}</td>
    <td> {{$bookingsystem['date']}}</td>
    <td> {{$bookingsystem['phonenumber']}}</td>
    <td> {{$bookingsystem['price']}}</td>
    </tr>
@endforeach
						   
					
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

