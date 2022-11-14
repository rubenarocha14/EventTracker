window.addEventListener('load', function() {
	console.log('script.js loaded.');
	init();
});

function init() {
	//setup Event listeners
	//load initial data
	loadPlayerList();
	loadCourseList();
	let newPlayer = document.getElementById("createPlayerForm");
	newPlayer.addPlayerBtn.addEventListener('click', function(evt){
		evt.preventDefault();
		//console.log('clicked');
		let player = {
			firstName : newPlayer.fname.value,
			lastName : newPlayer.lname.value,
			city : newPlayer.city.value,
			state : newPlayer.state.value,
		}
		createPlayer(player);
	})
};

function displayError(msg) {
	let errorDiv = document.getElementById('errorsDiv');
	errorDiv.textContent = '';
	let h4 = document.createElement('h4');
	h4.textContent = msg;
	errorDiv.appendChild(h4);
}

function loadRounds() {	//xhr to get the player list
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/rounds');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status == 200) {
				//TODO: show data
				let players = JSON.parse(xhr.responseText);
				displayPlayerList(players);
			} else {
				//display error
			}
		}
	};
	xhr.send();
}


function deletePlayer(player) {
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/players/' + player.id);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 204) {
				loadPlayerList();
			}
			else {
				displayError('Error deleting Player: ' + xhr.status + ', ' + xhr.statusText);
			}
		}
	};
	xhr.send();
	}

function displayPlayer(player) {
	let getPlayerDiv = document.getElementById('playerDetailsDiv');
	getPlayerDiv.textContent = '';
	let h2 = document.createElement('h2');
	let deleteBtn = document.createElement('button');
	let toggleUpdateForm = document.getElementById("toggleUpdateForm");
	let toggleUpdateBtn = document.getElementById("toggleUpdateBtn");
	deleteBtn.textContent = "Delete " + player.firstName + " " + player.lastName;
	h2.textContent = player.firstName + " " + player.lastName;
	console.log(player);
	getPlayerDiv.appendChild(h2);
	getPlayerDiv.appendChild(deleteBtn);
	getPlayerDiv.appendChild(updatePlayerForm);
	h2.addEventListener('mouseover', function handleMouseOver() {
		h2.style.color = 'white';
		h2.style.backgroundColor = "#90A4AE"
	});
	h2.addEventListener('mouseout', function handleMouseOut() {
		h2.style.color = 'black';
		h2.style.backgroundColor = ""
	});
	deleteBtn.addEventListener('click', function displayDeleteButton(){
		deletePlayer(player);
	})
	toggleUpdateBtn.addEventListener("click", function showUpdateForm(){
		toggleUpdateForm.style.display = "none";
	});


}


//load from db
function loadPlayerList() {
	//xhr to get the player list
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/players');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status == 200) {
				//TODO: show data
				let players = JSON.parse(xhr.responseText);
				displayPlayerList(players);
			} else {
				//display error
			}
		}
	};
	xhr.send();
}

function getPlayer(playerId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/players/' + playerId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let player = JSON.parse(xhr.responseText);
				displayPlayer(player);
			} else {
				displayError("Error retrieving caves: " + xhr.status);
			}
		}
	};
	xhr.send();
}


//display in table
function displayPlayerList(players) {
	//add players to DOM
	let tbody = document.getElementById('playerTableBody');
	tbody.textContent = '';
	if (players && Array.isArray(players) && players.length > 0) {
		for (let player of players) {
			let tr = document.createElement('tr');
			let td = document.createElement('td');
			td.textContent = player.id;
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = player.firstName;
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = player.lastName;
			//console.log(player.name);
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = player.city;
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = player.state;
			tr.appendChild(td);
			tbody.appendChild(tr);
			//bind click event
			tr.addEventListener('click', function(evt) {
				getPlayer(player.id);
			});
		}
	}
}

//retrieve courses from db
function loadCourseList() {
	let xhr2 = new XMLHttpRequest();
	xhr2.open('GET', 'api/courses');
	xhr2.onreadystatechange = function() {
		if (xhr2.readyState === xhr2.DONE) {
			if (xhr2.status == 200) {
				let courses = JSON.parse(xhr2.responseText);
				displayCourseList(courses);
				console.log(courses);
			} else {
				displayError("Error retrieving courses: " + xhr2.status);
			}
		}
	};
	xhr2.send();

}

function createPlayer(player) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/players');

	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 201) {
				let createdPlayer = JSON.parse(xhr.responseText);
				displayPlayer(createdPlayer);
			}
			else {
				displayError('Error creating Trainer: ' + xhr.status + ', ' + xhr.statusText);
			}
		}
	};
	let playerJson = JSON.stringify(player);
	xhr.send(playerJson);
}



function displayCourseList(courses) {
	//add players to DOM
	let tbody = document.getElementById('courseTableBody'); //get the table we created in html
	tbody.textContent = '';
	if (courses && Array.isArray(courses) && courses.length > 0) {
		for (let course of courses) {
			let tr = document.createElement('tr'); //create a tbl row element 
			let td = document.createElement('td'); //create a tbl data element
			td.textContent = course.id; //assign the value 
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = course.name;
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = course.city;
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = course.state;
			tr.appendChild(td);
			tbody.appendChild(tr);
		}
	}




}

//CRUD Op.	HTTP Verb	URI	RequestBody	ResponseBody
//Read Player	GET	api/players		List of all Players
//Read Player	GET	api/players/{playerId}		Singular Player
//Create Player	POST	api/players/	JSON for new Player	JSON of created Player
//Update Player	PUT	api/players/{playerId}	JSON for update Player	JSON of updated Player
//Delete Player	DELETE	api/players/{playerId}		
//---------------	------------	--------------------------	-----------------------	------------------------
//Read Course	GET	api/courses		List of all Courses
//Read Course	GET	api/course{courseId}		Singular Course
//Create Course	POST	api/courses	JSON for new Course	JSON of created Course
//Update Course	PUT	api/courses{courseId}	JSON for update Course	JSON of updated Course
//Delete Course	DELETE	api/courses{courseId}		
//---------------	------------	--------------------------	-----------------------	------------------------
//Read Round	GET	api/rounds		List of all Rounds
//Read Round	GET	api/rounds{roundId}		Singular Round
//Create Round	POST	api/rounds	JSON for new Round	JSON of created Round
//Update Round	PUT	api/rounds{roundId}	JSON for update Round	JSON of updated Round
//Delete Round	DELETE	api/rounds{roundId}	