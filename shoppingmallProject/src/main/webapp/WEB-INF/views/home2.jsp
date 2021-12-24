<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Fashi | Template</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="/shop/resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/themify-icons.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="/shop/resources/css/style.css"
	type="text/css">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<header class="header-section">
		<div class="header-top">
			<div class="container">
				<div class="ht-left"></div>
			</div>
		</div>
		<div class="container">
			<div class="inner-header">
				<div class="row">
					<div class="col-lg-2 col-md-2">
						<div class="logo">
							<a href="./index.html"> <img
								src="/shop/resources/img/logo.png" alt="logo"
								style="width: 50px; height: 50px;">
							</a>
						</div>
					</div>
					<div class="col-lg-7 col-md-7">
						<form action="/shop/product/serch" method="get">
							<div class="advanced-search">
								<button type="button" class="category-btn">상품명</button>
								<div class="input-group">
									<input type="text" placeholder="What do you need?" name="serch">
									<button type="submit">
										<i class="ti-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-lg-3 text-right col-md-3">
						<ul class="nav-right">
							<li class="heart-icon"><a href="#"> <i
									class="icon_heart_alt"></i> <span>1</span>
							</a></li>
							<li class="cart-icon"><a href="#"> <i
									class="icon_bag_alt"></i> <span>3</span>
							</a>
								<div class="cart-hover">
									<div class="select-items">
										<table>
											<tbody>
												<tr>
													<td class="si-pic"><img
														src="/shop/resources/img/select-product-1.jpg" alt=""></td>
													<td class="si-text">
														<div class="product-selected">
															<p>$60.00 x 1</p>
															<h6>Kabino Bedside Table</h6>
														</div>
													</td>
													<td class="si-close"><i class="ti-close"></i></td>
												</tr>
												<tr>
													<td class="si-pic"><img
														src="/shop/resources/img/select-product-2.jpg" alt=""></td>
													<td class="si-text">
														<div class="product-selected">
															<p>$60.00 x 1</p>
															<h6>Kabino Bedside Table</h6>
														</div>
													</td>
													<td class="si-close"><i class="ti-close"></i></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="select-total">
										<span>total:</span>
										<h5>$120.00</h5>
									</div>
									<div class="select-button">
										<a href="#" class="primary-btn view-card">VIEW CARD</a> <a
											href="#" class="primary-btn checkout-btn">CHECK OUT</a>
									</div>
								</div></li>
							<li class="cart-price">$150.00</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="nav-item">
			<div class="container">
				<div class="nav-depart">
				</div>
				<nav class="nav-menu mobile-menu">
					<ul>
						<li class="active"><a href="/shop/product/listAll">ALL</a></li>
						<li><a href="/shop/product/listCasual">Casual</a></li>
						<li><a href="/shop/product/listOffice">Office</a></li>
						<li><a href="/shop/product/listFeminine">Feminine</a></li>
						<li><a href="/shop/product/listHip">Hip</a></li>
						<li><a href="/shop/product/listVintage">Vintage</a></li>
						<li><a href="/shop/product/listDaily">Daily</a></li>
					</ul>
				</nav>
				<div id="mobile-menu-wrap"></div>
			</div>
		</div>
	</header>
	<!-- Header End -->

	<!-- Hero Section Begin -->
	<section class="hero-section">
		<div class="hero-items owl-carousel">
			<div class="single-hero-items set-bg"
				data-setbg="/shop/resources/img/hero-1.jpg">
				<div class="container">
					<div class="row">
						<div class="col-lg-5">
							<span>Bag,kids</span>
							<h1>Black friday</h1>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore</p>
							<a href="#" class="primary-btn">Shop Now</a>
						</div>
					</div>
					<div class="off-card">
						<h2>
							Sale <span>50%</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="single-hero-items set-bg"
				data-setbg="/shop/resources/img/hero-2.jpg">
				<div class="container">
					<div class="row">
						<div class="col-lg-5">
							<span>Bag,kids</span>
							<h1>Black friday</h1>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore</p>
							<a href="#" class="primary-btn">Shop Now</a>
						</div>
					</div>
					<div class="off-card">
						<h2>
							Sale <span>50%</span>
						</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Banner Section Begin -->
	<div class="banner-section spad">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-4">
					<a href="/shop/product/listAll">
						<div class="single-banner">
							<img src="/shop/resources/img/banner-1.jpg" alt="전체상품리스트">
							<div class="inner-text">
								<h4>상품전체</h4>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4">
					<a href="/shop/product/listFeminine">
						<div class="single-banner">
							<img src="/shop/resources/img/banner-2.jpg" alt="페미닌">
							<div class="inner-text">
								<h4>페미닌</h4>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4">
					<a href="/shop/product/listDaily">
						<div class="single-banner">
							<img src="/shop/resources/img/banner-3.jpg" alt="페미닌">
							<div class="inner-text">
								<h4>오늘배송</h4>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner Section End -->

	<!-- Women Banner Section Begin -->
	<section class="women-banner spad">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3">
					<div class="product-large set-bg"
						data-setbg="/shop/resources/img/products/women-large.jpg">
						<h2>Women’s</h2>
						<a href="#">Discover More</a>
					</div>
				</div>
				<div class="col-lg-8 offset-lg-1">
					<div class="filter-control">
						<ul>
							<li class="active">Clothings</li>
							<li>HandBag</li>
							<li>Shoes</li>
							<li>Accessories</li>
						</ul>
					</div>
					<div class="product-slider owl-carousel">
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/women-1.jpg" alt="">
								<div class="sale">Sale</div>
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Coat</div>
								<a href="#">
									<h5>Pure Pineapple</h5>
								</a>
								<div class="product-price">
									$14.00 <span>$35.00</span>
								</div>
							</div>
						</div>
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/women-2.jpg" alt="">
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Shoes</div>
								<a href="#">
									<h5>Guangzhou sweater</h5>
								</a>
								<div class="product-price">$13.00</div>
							</div>
						</div>
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/women-3.jpg" alt="">
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Towel</div>
								<a href="#">
									<h5>Pure Pineapple</h5>
								</a>
								<div class="product-price">$34.00</div>
							</div>
						</div>
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/women-4.jpg" alt="">
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Towel</div>
								<a href="#">
									<h5>Converse Shoes</h5>
								</a>
								<div class="product-price">$34.00</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Women Banner Section End -->

	<!-- Deal Of The Week Section Begin-->
	<section class="deal-of-week set-bg spad"
		data-setbg="/shop/resources/img/time-bg.jpg">
		<div class="container">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h2>Deal Of The Week</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed<br />
						do ipsum dolor sit amet, consectetur adipisicing elit
					</p>
					<div class="product-price">
						$35.00 <span>/ HanBag</span>
					</div>
				</div>
				<div class="countdown-timer" id="countdown">
					<div class="cd-item">
						<span>56</span>
						<p>Days</p>
					</div>
					<div class="cd-item">
						<span>12</span>
						<p>Hrs</p>
					</div>
					<div class="cd-item">
						<span>40</span>
						<p>Mins</p>
					</div>
					<div class="cd-item">
						<span>52</span>
						<p>Secs</p>
					</div>
				</div>
				<a href="#" class="primary-btn">Shop Now</a>
			</div>
		</div>
	</section>
	<!-- Deal Of The Week Section End -->

	<!-- Man Banner Section Begin -->
	<section class="man-banner spad">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-8">
					<div class="filter-control">
						<ul>
							<li class="active">Clothings</li>
							<li>HandBag</li>
							<li>Shoes</li>
							<li>Accessories</li>
						</ul>
					</div>
					<div class="product-slider owl-carousel">
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/man-1.jpg" alt="">
								<div class="sale">Sale</div>
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Coat</div>
								<a href="#">
									<h5>Pure Pineapple</h5>
								</a>
								<div class="product-price">
									$14.00 <span>$35.00</span>
								</div>
							</div>
						</div>
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/man-2.jpg" alt="">
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Shoes</div>
								<a href="#">
									<h5>Guangzhou sweater</h5>
								</a>
								<div class="product-price">$13.00</div>
							</div>
						</div>
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/man-3.jpg" alt="">
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Towel</div>
								<a href="#">
									<h5>Pure Pineapple</h5>
								</a>
								<div class="product-price">$34.00</div>
							</div>
						</div>
						<div class="product-item">
							<div class="pi-pic">
								<img src="/shop/resources/img/products/man-4.jpg" alt="">
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a href="#"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a href="#">+ Quick View</a></li>
									<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Towel</div>
								<a href="#">
									<h5>Converse Shoes</h5>
								</a>
								<div class="product-price">$34.00</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 offset-lg-1">
					<div class="product-large set-bg m-large"
						data-setbg="/shop/resources/img/products/man-large.jpg">
						<h2>Men’s</h2>
						<a href="#">Discover More</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Man Banner Section End -->

	<!-- Instagram Section Begin -->
	<div class="instagram-photo">
		<div class="insta-item set-bg"
			data-setbg="/shop/resources/img/insta-1.jpg">
			<div class="inside-text">
				<i class="ti-instagram"></i>
				<h5>
					<a href="#">colorlib_Collection</a>
				</h5>
			</div>
		</div>
		<div class="insta-item set-bg"
			data-setbg="/shop/resources/img/insta-2.jpg">
			<div class="inside-text">
				<i class="ti-instagram"></i>
				<h5>
					<a href="#">colorlib_Collection</a>
				</h5>
			</div>
		</div>
		<div class="insta-item set-bg"
			data-setbg="/shop/resources/img/insta-3.jpg">
			<div class="inside-text">
				<i class="ti-instagram"></i>
				<h5>
					<a href="#">colorlib_Collection</a>
				</h5>
			</div>
		</div>
		<div class="insta-item set-bg"
			data-setbg="/shop/resources/img/insta-4.jpg">
			<div class="inside-text">
				<i class="ti-instagram"></i>
				<h5>
					<a href="#">colorlib_Collection</a>
				</h5>
			</div>
		</div>
		<div class="insta-item set-bg"
			data-setbg="/shop/resources/img/insta-5.jpg">
			<div class="inside-text">
				<i class="ti-instagram"></i>
				<h5>
					<a href="#">colorlib_Collection</a>
				</h5>
			</div>
		</div>
		<div class="insta-item set-bg"
			data-setbg="/shop/resources/img/insta-6.jpg">
			<div class="inside-text">
				<i class="ti-instagram"></i>
				<h5>
					<a href="#">colorlib_Collection</a>
				</h5>
			</div>
		</div>
	</div>
	<!-- Instagram Section End -->

	<!-- Latest Blog Section Begin -->
	<section class="latest-blog spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>From The Blog</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="single-latest-blog">
						<img src="/shop/resources/img/latest-1.jpg" alt="">
						<div class="latest-text">
							<div class="tag-list">
								<div class="tag-item">
									<i class="fa fa-calendar-o"></i> May 4,2019
								</div>
								<div class="tag-item">
									<i class="fa fa-comment-o"></i> 5
								</div>
							</div>
							<a href="#">
								<h4>The Best Street Style From London Fashion Week</h4>
							</a>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-latest-blog">
						<img src="/shop/resources/img/latest-2.jpg" alt="">
						<div class="latest-text">
							<div class="tag-list">
								<div class="tag-item">
									<i class="fa fa-calendar-o"></i> May 4,2019
								</div>
								<div class="tag-item">
									<i class="fa fa-comment-o"></i> 5
								</div>
							</div>
							<a href="#">
								<h4>Vogue's Ultimate Guide To Autumn/Winter 2019 Shoes</h4>
							</a>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-latest-blog">
						<img src="/shop/resources/img/latest-3.jpg" alt="">
						<div class="latest-text">
							<div class="tag-list">
								<div class="tag-item">
									<i class="fa fa-calendar-o"></i> May 4,2019
								</div>
								<div class="tag-item">
									<i class="fa fa-comment-o"></i> 5
								</div>
							</div>
							<a href="#">
								<h4>How To Brighten Your Wardrobe With A Dash Of Lime</h4>
							</a>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
			</div>
			<div class="benefit-items">
				<div class="row">
					<div class="col-lg-4">
						<div class="single-benefit">
							<div class="sb-icon">
								<img src="/shop/resources/img/icon-1.png" alt="">
							</div>
							<div class="sb-text">
								<h6>Free Shipping</h6>
								<p>For all order over 99$</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="single-benefit">
							<div class="sb-icon">
								<img src="/shop/resources/img/icon-2.png" alt="">
							</div>
							<div class="sb-text">
								<h6>Delivery On Time</h6>
								<p>If good have prolems</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="single-benefit">
							<div class="sb-icon">
								<img src="/shop/resources/img/icon-1.png" alt="">
							</div>
							<div class="sb-text">
								<h6>Secure Payment</h6>
								<p>100% secure payment</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Latest Blog Section End -->

	<!-- Partner Logo Section Begin -->
	<div class="partner-logo">
		<div class="container">
			<div class="logo-carousel owl-carousel">
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="/shop/resources/img/logo-carousel/logo-1.png" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="/shop/resources/img/logo-carousel/logo-2.png" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="/shop/resources/img/logo-carousel/logo-3.png" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="/shop/resources/img/logo-carousel/logo-4.png" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="/shop/resources/img/logo-carousel/logo-5.png" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Partner Logo Section End -->

	<!-- Footer Section Begin -->

	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="/shop/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/shop/resources/js/bootstrap.min.js"></script>
	<script src="/shop/resources/js/jquery-ui.min.js"></script>
	<script src="/shop/resources/js/jquery.countdown.min.js"></script>
	<script src="/shop/resources/js/jquery.nice-select.min.js"></script>
	<script src="/shop/resources/js/jquery.zoom.min.js"></script>
	<script src="/shop/resources/js/jquery.dd.min.js"></script>
	<script src="/shop/resources/js/jquery.slicknav.js"></script>
	<script src="/shop/resources/js/owl.carousel.min.js"></script>
	<script src="/shop/resources/js/main.js"></script>
</body>

</html>