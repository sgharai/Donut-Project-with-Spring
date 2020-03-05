
console.log("This script works!")

// .then(json => json.array.forEach(element => {
//     let tr = document.createElement("tr")
//     tr.innerHTML = `${element}`
//     document.querySelzzector(tbody)
//     tbody.appendChild(tr);
// }))

fetch('http://localhost:8080/donuts')
    .then(response => response.json())
    .then(json => {
        for (el in json) {
            console.log(json[el])
            // console.log(json[el].name)
            let tbody = document.querySelector("tbody")
            let tr = document.createElement("tr")
            tr.setAttribute("contenteditable", "false")
            tr.classList = `row-${json[el].id} item`
            tr.innerHTML = `<td>${json[el].id}</td>
            <td id="${json[el].id}-name">${json[el].name}</td>
            <td id="${json[el].id}-frosted">
            ${json[el].frosted ? "frosted" : "not frosted"}
            <label class="checkbox">
            <input id="${json[el].id}-checkbox" type="checkbox" ${json[el].frosted ? "checked" : ""}>
          </label>
            </td>
            <td id="${json[el].id}-type">${json[el].donutType}</td>
            <td><i class="fa fa-trash icon-${json[el].id}" style="cursor:pointer" onclick="deleteItem(${json[el].id})"></i></td>
            <td><i class="fas fa-pencil-alt icon-${json[el].id}" style="cursor:pointer" onclick="updateItem(${json[el].id})"></i></td>
            <td><i class="fas fa-save icon-${json[el].id}" style="cursor:pointer" onclick="saveItem(${json[el].id})"></i></td>`
            tbody.appendChild(tr)
        }
    })



// delete method that is tied to the trashcan icon

const deleteItem = (id) => {
    let item = document.querySelector(`.row-${id}`)
    fetch(`http://localhost:8080/donut/${id}`, {
        method: 'DELETE',
    })
        .then(item.remove())
        .then(console.log(`this works`))


}

// update function that will be tied to pencil icon
// this function will allow the text in our rows to be editable

const updateItem = (id) => {
    let item = document.querySelector(`.row-${id}`)
    item.toggleAttribute("contenteditable")


}


// save function that calls the PUT HTTP method
// it takes the innertext in our row elements and saves it to our backend

const saveItem = (id) => {
    let nameInput = document.getElementById(`${id}-name`).innerText
    let frostedInput = (document.getElementById(`${id}-checkbox`).checked ? true : false)
    let typeInput = document.getElementById(`${id}-type`).innerText

    let sampleDonut = {
        name: nameInput,
        frosted: frostedInput,
        donutType: typeInput
    }

    console.log(sampleDonut)

    fetch(`http://localhost:8080/donut/${id}`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(sampleDonut)
    })
        .then(response => response.json)
        .then(json => console.log(json))
}




// this add method works completely fine!


const addItem = () => {

    let nameInput = document.getElementById("name").value
    let frostedInput = (document.getElementById(`checkbox`).checked ? true : false)
    let typeInput = document.getElementById("type").value


    let sampleDonut = {
        name: nameInput,
        frosted: frostedInput,
        donutType: typeInput
    }

    console.log(sampleDonut)
    fetch(`http://localhost:8080/donut`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(sampleDonut)

    }).then(console.log("cake posted!"))
        .then(location.reload())

}