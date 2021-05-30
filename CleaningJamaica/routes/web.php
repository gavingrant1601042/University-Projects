<?php

use Illuminate\Support\Facades\Route;
use Illuminate\support\Facades\PagesController;
use Illuminate\support\Facades\ContactController;
use Illuminate\support\Facades\DatabasePost;
use App\Http\Controllers\BookingController;
use RealRashid\SweetAlert\Facades\Alert;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
toast('Login/Operation Successful','success');
Route::get('/', function () {
    return view('index');
});
Route::get('list',[BookingController::class,'show']);
Route::get('/index',[App\Http\Controllers\PagesController::class,'index']);
Route::get('/about',[App\Http\Controllers\PagesController::class,'about']);
Route::get('/Login',[App\Http\Controllers\PagesController::class,'Login']);
Route::post('/insert',[App\Http\Controllers\DatabasePost::class,'insert']);
Route::get('/contactform',[App\Http\Controllers\PagesController::class,'contactform']);
Route::post('/send-message',[App\Http\Controllers\ContactController::class,'sendEmail'])->name('contact.send');
Route::middleware(['auth:sanctum', 'verified'])->get('/dashboard', function () {
    return view('dashboard');
})->name('dashboard');
