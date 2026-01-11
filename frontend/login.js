async function login(e) {
    e.preventDefault();
  
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");
  
    console.log("USERNAME SENT =", usernameInput.value);
    console.log("PASSWORD SENT =", passwordInput.value);
  
    const res = await fetch("http://localhost:8080/api/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: usernameInput.value,   // ✅ string from input
        password: passwordInput.value
      })
    });
  
    const json = await res.json();
    console.log(json);
  
    if (!json.success) {
      alert(json.message);
      return;
    }
  
    localStorage.setItem("token", json.data.token);
    localStorage.setItem("role", json.data.role);
  
    window.location.href = "index.html";
  }
  