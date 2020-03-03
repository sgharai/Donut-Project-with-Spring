


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
            tr.innerHTML = `<td>${json[el].id}</td><td>${json[el].name}</td><td>${json[el].frosted ? 'frosted' : 'unfrosted'}</td>`
            tbody.appendChild(tr)
        }
    })