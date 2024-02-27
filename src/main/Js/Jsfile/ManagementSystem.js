let students = []

function addStudent(student){
    let table = $("#studentTable tbody")
    
    table.append(`
        <tr id="${student.id}">
            <td>${student.name}</td>
            <td>${student.id}</td>
            <td>${student.email}</td>
            <td>${student.subjectOne}</td>
            <td>${student.subjectTwo}</td>
            <td>${student.subjectThree}</td>
            <td>${student.gpa}</td>
            <td><button class="btn btn-sm btn-warning editBtn" data-id="${student.id}">Edit</button>
            <button class="btn btn-sm btn-danger deleteBtn" data-id="${student.id}">Delete</button></td>
    `)
}

function clearForm(){
    $("#addstudentname").val("")
    $("#addstudentemail").val("")
    $("#addsubjectone").val("")
    $("#addsubjecttwo").val("")
    $("#addsubjectthree").val("")
    
}

function sumThreeSubject(){
    var one = parseInt(document.getElementById("addsubjectone").value)
    var two = parseInt(document.getElementById("addsubjecttwo").value)
    var three = parseInt(document.getElementById("addsubjectthree").value)
    var result = (one+two+three)/3
    return result.toFixed(2)
}

function generateId(){
    
    return Math.floor(Math.random()*1000000)
}

$(document).on("click", "#clbtn", function(){
    clearForm()
})

$("#studentform").submit(function(e){
    e.preventDefault()
    let student = {
        name: $("#studentname").val(),
        id: generateId(),
        email: $("#studentemail").val(),
        subjectOne: $("#subjectone").val(),
        subjectTwo: $("#subjecttwo").val(),
        subjectThree: $("#subjectthree").val(),
        gpa: sumThreeSubject()
    }
    students.push(student)
    addStudent(student)
    clearForm()
})

function sumThreeSubjectEdit(){
    var one = parseInt(document.getElementById("editsubjectone").value)
    var two = parseInt(document.getElementById("editsubjecttwo").value)
    var three = parseInt(document.getElementById("editsubjectthree").value)
    var result = (one+two+three)/3
    return result.toFixed(2)
}

$("#editForm").submit(function(e){
    e.preventDefault()
    let studentId = $("#editStudentId").val()
    let studentGPA = $("#editGPA").val()
    let studentIndex = students.findIndex((student)=> student.id == studentId)
    let student = students[studentIndex]

    student.name = $("#editstudentname").val()
    student.email = $("#editstudentemail").val()
    student.subjectOne = $("#editsubjectone").val()
    student.subjectTwo = $("#editsubjecttwo").val()
    student.subjectThree = $("#editsubjectthree").val()
    student.gpa = sumThreeSubjectEdit()

    let row = $(`#${student.id}`)
    row.find("td:eq(0)").text(student.name)
    row.find("td:eq(2)").text(student.email)
    row.find("td:eq(3)").text(student.subjectOne)
    row.find("td:eq(4)").text(student.subjectTwo)
    row.find("td:eq(5)").text(student.subjectThree)
    row.find("td:eq(6)").text(student.gpa)

    $("#editModal").modal("hide")

})

$(document).on("click", ".editBtn", function(){
    let studentId = $(this).data("id")
    //let studentGPA = $(this).data("id")
    let studentIndex = students.findIndex((student)=> student.id == studentId)
    let student = students[studentIndex]

    $("#editstudentname").val(student.name)
    $("#editstudentemail").val(student.email)
    $("#editsubjectone").val(student.subjectOne)
    $("#editsubjecttwo").val(student.subjectTwo)
    $("#editsubjectthree").val(student.subjectThree)
    $("#editStudentId").val(student.id)
    

    $("#editModal").modal("show")
})

$(document).on("click", "#clsbtn", function(){
    $("#editModal").modal("hide")
})

$(document).on("click", ".deleteBtn", function(){
    let studentId = $(this).data("id")
    //let studentGPA = $(this).data("id")
    let studentIndex = students.findIndex((student)=> student.id == studentId)
    let student = students[studentIndex]

    if(confirm(`Are you sure you want to detele ${student.name}`)){
        students.splice(studentIndex, 1)
        $(`#${student.id}`).remove()
    }
})

$('#addBtn').on('click', function() {
    $("#addModal").modal("show")
});

$(document).on("click", "#clsaddbtn", function(){
    $("#addModal").modal("hide")
})

$("#addForm").submit(function(e){
    e.preventDefault()
    let student = {
        name: $("#addstudentname").val(),
        id: generateId(),
        email: $("#addstudentemail").val(),
        subjectOne: $("#addsubjectone").val(),
        subjectTwo: $("#addsubjecttwo").val(),
        subjectThree: $("#addsubjectthree").val(),
        gpa: sumThreeSubject()
    }
    students.push(student)
    addStudent(student)
    clearForm()
    $("#addModal").modal("hide")
    //alert("Added student successful")
})

// Search student

$('#searchBtn').on('click', function() {
    $("#searchModal").modal("show")
});
  
//   function loadList() {
//     let temp = `<ul class="list-items">`;
//     list.forEach((item) => {
//       temp += `<li class="list-item"> ${item} </li>`;
//     });
//     temp += `</ul>`;
//     output.innerHTML = temp;
//   }

const output = document.querySelector(".output");
  const search = document.querySelector(".filter-input");
  
  //window.addEventListener("DOMContentLoaded", loadList);
  search.addEventListener("input", filter);
  search.remove
  
function filter(e) {
    let temp = ' ';
    let result  = students.filter(student => student.name.toLowerCase().includes(e.target.value.toLowerCase()));
    //result = students.filter(student => student.email.toLowerCase().includes(e.target.value.toLowerCase()))
    if(result.length>0){
        temp = `<table class="table mt-4" id="studentSearchTable">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>GPA</th>
            </tr>
        </thead>`
        ;
        result.forEach((student) => {
          temp += `<tbody><tr>
                        <td> ${student.id} </td>
                        <td> ${student.name} </td>
                        <td> ${student.email} </td>
                        <td> ${student.gpa} </td>
                    </tr></tbody>`;
        });
        temp += `</table>`;
    }
    else{
        temp =`<div class="no-item"> No Item Found </div>`
    }
    output.innerHTML = temp

}