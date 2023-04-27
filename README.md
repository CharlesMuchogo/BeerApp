# BeerApp


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
 A Kotlin Jetpack Compose App using Retrofit to Fetch and Display Data from Punk API
</head>
<body>
	<h1>Kotlin Jetpack Compose App using Retrofit to Fetch and Display Data from Punk API</h1>
	<p>This Kotlin Jetpack Compose app is designed to fetch data from the <a href="https://punkapi.com/">Punk API</a> using Retrofit and display it in a nice way on the app. The app is built using the latest Android development tools, including Jetpack Compose, ViewModel, Hilt, and Retrofit.</p>
	<h2>Features</h2>
	<ul>
		<li>Fetches beer data from the Punk API using Retrofit</li>
		<li>Displays the beer data using Jetpack Compose UI components</li>
		<li>Handles loading and error states using a state flow and sealed classes</li>
		<li>Uses Hilt to inject dependencies</li>
		<li>Follows the MVVM architecture pattern</li>
	</ul>
	<h2>Dependencies</h2>
	<ul>
		<li><a href="https://developer.android.com/kotlin/coroutines">Kotlin Coroutines</a> for asynchronous programming</li>
		<li><a href="https://square.github.io/retrofit/">Retrofit</a> for network requests</li>
		<li><a href="https://github.com/square/moshi">Moshi</a> for JSON parsing</li>
		<li><a href="https://developer.android.com/jetpack/compose">Jetpack Compose</a> for building UI</li>
		<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a> for managing UI data</li>
		<li><a href="https://developer.android.com/kotlin/flow/stateflow-and-sharedflow">State Flow</a> for managing the UI state</li>
		<li><a href="https://developer.android.com/training/dependency-injection/hilt-android">Hilt</a> for dependency injection</li>
	</ul>
	<h2>Prerequisites</h2>
	<ul>
		<li>Android Studio Arctic Fox or later</li>
		<li>Android SDK 31 or later</li>
		<li>Kotlin 1.5.21 or later</li>
	</ul>
	<h2>Usage</h2>
	<ol>
		<li>Clone or download the repository to your local machine.</li>
		<li>Open the project in Android Studio.</li>
		<li>Build and run the app on an emulator or physical device.</li>
	</ol>
	<h2>How it Works</h2>
	<ol>
		<li>The app uses Retrofit to fetch data from the Punk API.</li>
		<li>The fetched data is parsed using Moshi and stored in a <code>Beer</code> data class.</li>
		<li>The <code>BeerViewModel</code> fetches the beer data using a coroutine and updates the UI state using a <code>StateFlow</code> and sealed classes.</li>
		<li>The <code>BeerListScreen</code> composable displays the beer data using Jetpack Compose UI components, including a <code>LazyColumn</code>, <code>Card</code>, and <code>Text</code>.</li>
</body>
</html>
