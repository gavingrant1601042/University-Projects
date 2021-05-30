
<x-app-layout>
    <x-slot name="header">
        <h2 class="font-semibold text-xl text-gray-800 leading-tight">
            {{ __('Customer Booking System') }}
        </h2>
        
    </x-slot>

   


    <link type="text/css" rel="stylesheet" href="Booking.css" />


    <div class="py-12">
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
        
            <div class="bg-white overflow-hidden shadow-xl sm:rounded-lg">
              

            <div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">

					<form action="/insert" method="post">
					{{ csrf_field() }}
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                               
                                
                                 
                                
                                  
							<div class="row no-margin">
								<div class="col-md-3">
									<div class="form-group">
									<span class="form-label">Customer Name</span>
										<input class="form-control" type="text" name="name" placeholder="Enter your Name">
										<span class="form-label">Address</span>
										<input class="form-control" type="text" name="address" placeholder="Enter your Address">
									</div>
								</div>
								<div class="col-md-6">
									<div class="row no-margin">
										<div class="col-md-5">
											<div class="form-group">
												<span class="form-label">Appointment Date</span>
												<input class="form-control" name="date"  type="date" required>
											</div>
										</div>
										<div class="col-md-5">
											<div class="form-group">
												<span class="form-label">Contact Number</span>
    
												<input class = "form-control" type="tel" name="phonenumber"  id="phone_number"  pattern="^\d{10}$" required="required" placeholder="Enter PhoneNumber"/>
							
										
											</div>
										</div>
										<div class="col-md-2">
											<div class="form-group">
											    <p> Price 1 Room : $4300 JMD" </p>
												<p> Price 2 Room : $5300 JMD" </p>
												<p> Price 3 Room : $6300 JMD" </p>
												<p> Price 4 and more Room : $7300 JMD" </p>
												
								
												<span class="form-label">Rooms to be Cleaned</span>
												<input class="form-control" type="text" name="price"  placeholder=" Amt-Room To Be cleaned">


											</div>
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-btn">
									
										<button  class="submit-btn" value="Add">Book Appointment</button>
										@include('sweetalert::alert')
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>












    </br>
    </br>
    </br>
    </br>
    </br>
    </br>
    </br>

<br>
<br>
<br>
<br>
<br>
<br>
<br>

            </div>
        </div>
      
    </div>
  <center>  ALL RIGHTS RESERVED CLEANING JAMAICA </center>
</x-app-layout>
