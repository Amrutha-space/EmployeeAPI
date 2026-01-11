// ===== GLOBAL STATE (MUST BE AT TOP) =====
let page = 0;
let size = 5;
let search = "";
let editingId = null;


const BASE_URL = "http://localhost:8080/api/employees";

if (!localStorage.getItem("token")) {
  window.location.href = "login.html";
}

// Attach token to every request
function authHeaders() {
  const token = localStorage.getItem("token");
  return {
    "Content-Type": "application/json",
    "Authorization": "Bearer " + token
  };
}



async function loadEmployees() {
  const token = localStorage.getItem("token");
    const res = await fetch(`http://localhost:8080/api/employees?page=${page}&size=${size}&keyword=${search}`,
{
  headers: {
    "Content-Type": "application/json",
    "Authorization": "Bearer " + token
  }
}
);
    const json = await res.json();
  
    const employees = json.data.content;
    const totalPages = json.data.totalPages;
  
    // store for buttons
    window.totalPages = totalPages;
  
    const tbody = document.querySelector("#employeeTable tbody");
    tbody.innerHTML = "";
  
    employees.forEach(emp => {
      tbody.innerHTML += `
        <tr>
          <td>${emp.id}</td>
          <td>${emp.name}</td>
          <td>${emp.email}</td>
          <td>${emp.department}</td>
          <td>${emp.status}</td>
         <td>
  ${role === "ROLE_ADMIN"
    ? `
      <button class="btn btn-sm btn-warning"
        onclick='editEmployee(${JSON.stringify(emp)})'>Edit</button>
      <button class="btn btn-sm btn-danger"
        onclick="deleteEmployee(${emp.id})">Delete</button>
    `
    : ""
  }
</td>

            
        </tr>
    
      `;
    });
  
    updatePageInfo();
  
  function searchEmployees() {
    search = document.getElementById("searchBox").value;
    page = 0;   // reset to first page when searching
    loadEmployees();
  }
  
  function filterTable() {
    const query = document.getElementById("searchBox").value.toLowerCase();
    const rows = document.querySelectorAll("#employeeTable tbody tr");
  
    rows.forEach(row => {
      const text = row.innerText.toLowerCase();
      row.style.display = text.includes(query) ? "" : "none";
    });
  }
  
  function deleteEmployee(id) {
    if (!confirm("Delete this employee?")) return;
  
    fetch(`http://localhost:8080/api/employees/${id}`, {
      method: "DELETE",
      headers: authHeaders()
    })
    .then(() => loadEmployees());
  }

let page = 0;
let size = 5;
let search = "";


  let currentEditId = null;

  function editEmployee(emp) {
    currentEditId = emp.id;
  
    document.getElementById("formTitle").innerText = "Edit Employee";
  
    document.getElementById("name").value = emp.name;
    document.getElementById("email").value = emp.email;
    document.getElementById("department").value = emp.department;
    document.getElementById("gender").value = emp.gender;
    document.getElementById("status").value = emp.status;
  }

  function cancelEdit() {
    currentEditId = null;
    document.getElementById("addForm").reset();
    document.getElementById("formTitle").innerText = "Add Employee";
  }
  
  function nextPage() {
    if (page < window.totalPages - 1) {
      page++;
      loadEmployees();
    }
  }
  
  function prevPage() {
    if (page > 0) {
      page--;
      loadEmployees();
    }
  }

  function onSearchChange() {
    search = document.getElementById("searchBox").value;
    page = 0;
    loadEmployees();
  }
  
  
  function updatePageInfo() {
    document.getElementById("pageInfo").innerText =
      `Page ${page + 1} of ${totalPages}`;
  
    document.getElementById("prevBtn").disabled = page === 0;
    document.getElementById("nextBtn").disabled = page >= window.totalPages - 1;
  }
}
  
  
//  Page load behavior
window.onload = function () {
  loadEmployees();

  const role = localStorage.getItem("role");
  if (role !== "ROLE_ADMIN") {
    document.querySelectorAll(".admin-only")
      .forEach(btn => btn.style.display = "none");
  }
};


// Add Employee (form submit)

document.getElementById("addForm").addEventListener("submit", function(e) {
    e.preventDefault();
  
    const employee = {
      name: name.value,
      email: email.value,
      department: department.value,
      gender: gender.value,
      status: status.value
    };

    const method = currentEditId ? "PUT" : "POST";
    const url = currentEditId
      ? `http://localhost:8080/api/employees/${currentEditId}`
      : "http://localhost:8080/api/employees";
  
      fetch(url, {
        method,
        headers: authHeaders(),
        body: JSON.stringify(emp)
      })

    fetch(url, {
     method: method,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(employee)
    })
    .then(res => res.json())
    .then(() => {
        loadEmployees();
        e.target.reset();
      currentEditId = null;
      document.getElementById("formTitle").innerText = "Add Employee";
    });
  });
  

// Placeholder functions (optional)
function editEmployee(id) { alert("Edit: " + id); }
function deleteEmployee(id) { alert("Delete: " + id); }

window.onload = () => {
  loadEmployees();
};
