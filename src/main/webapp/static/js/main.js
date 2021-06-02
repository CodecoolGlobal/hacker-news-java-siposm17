let page = 1;
let numberOfPages;

function mainLogic() {
    // Puts the default data on cards
    fetchThenPutOnCards("/api/top");
    // Adding event listeners to button to change data type of content

    let topButton = document.getElementById('top_news');
    eventListenerToChangeData(topButton, "/api/top");

    let newestButton = document.getElementById('newest_news');
    eventListenerToChangeData(newestButton, "/api/newest");

    let jobsButton = document.getElementById('jobs');
    eventListenerToChangeData(jobsButton, "/api/jobs");
}

function addEventListenerToNext(element, url){
    element.addEventListener("click", () => {
        if(numberOfPages !== 0)page++;
        urlToFetch = url + "?page=" + page;
        fetchThenPutOnCards(urlToFetch);
    })
}

function addEventListenerToPrev(element, url){
    element.addEventListener("click", () => {
        if(page > 1) page--;
        urlToFetch = url + "?page=" + page;
        fetchThenPutOnCards(urlToFetch);
    })
}

function fetchThenPutOnCards(url){
    fetch(url)
        .then(r => r.json())
        .then(d => {
            if(d !== [])putDataOnCards(d);
        })
}

function eventListenerToChangeData(element, url){
    element.addEventListener("click", () => {
        removeNextAndPrevious();
        addNextAndPrevious(url);
        fetchThenPutOnCards(url);
    })
}

function removeNextAndPrevious(){
    let nextButton = document.getElementById("nextButton");
    let prevButton = document.getElementById("prevButton");
    if(nextButton !== null && prevButton !== null) {
        nextButton.remove();
        prevButton.remove();
    }
}

function addNextAndPrevious(url){
    let buttons = document.getElementById("buttons");

    let nextButton = document.createElement("button");
    nextButton.id = "nextButton";
    nextButton.textContent = "Next";
    nextButton.setAttribute("type", "button");
    nextButton.classList.add("btn-dark", "btn");
    nextButton.style = "float: right; margin-right: 75px;";
    buttons.append(nextButton);
    addEventListenerToNext(nextButton, url);

    let prevButton = document.createElement("button");
    prevButton.textContent = "Previous";
    prevButton.id = "prevButton";
    prevButton.setAttribute("type", "button");
    prevButton.classList.add("btn-dark", "btn");
    prevButton.style = "float: right;";
    addEventListenerToPrev(prevButton, url);
    buttons.append(prevButton);
}


function putDataOnCards(data){

    numberOfPages = Object.keys(data).length;
    let content = document.getElementById("inner_content");
    content.innerHTML = "";


    for (let i = 0; i < numberOfPages; i++) {
        // Creating new div element
        let newDiv = document.createElement("div");
        // Appending the new div to the inner content section
        content.append(newDiv);
        // Putting "card" class on the div
        newDiv.classList.add("card");

        // Modifing div style so it can fit
        // newDiv.style = "width: 400px; max-width: 400px; height: 160px; max-height: 160px; float: left; background-color: grey; margin-bottom: 100px; margin-left: 100px; display: inline-block;";
        newDiv.style="width: 18rem; display:inline-block; margin-bottom: 75px; margin-left: 75px;"
        // Creating new ul
        let ul = document.createElement("ul");
        // Adding bootstrap to new ul
        ul.classList.add("list-group", "list-group-flush");
        // Adding the ul to the div
        newDiv.append(ul);
        // Appending newly made li to the ul
        // 1(Title)
        let liTitle = document.createElement("li");
        liTitle.innerHTML = "<a href='" + data[i].url + "'>" + data[i].title + "</a>";
        liTitle.classList.add("list-group-item");
        ul.append(liTitle);
        // 2(Author)
        if(data[i].user != null) {
            let liAuthor = document.createElement("li");
            liAuthor.innerText = data[i].user;
            liAuthor.classList.add("list-group-item");
            ul.append(liAuthor);
        }
        // 3(TimeAgo)
        let liTimeAgo = document.createElement("li");
        liTimeAgo.innerText = data[i].time_ago;
        liTimeAgo.classList.add("list-group-item");
        ul.append(liTimeAgo);

    }
}

mainLogic();