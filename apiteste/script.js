const formulario = document.querySelector("form")
const iNome = document.querySelector(".nome")
const iEmail = document.querySelector(".email")
const iSenha = document.querySelector(".senha")
const iTel = document.querySelector(".tel")

const successMessage = document.getElementById('messageSuccess');
const errorMessage = document.getElementById('messageError');


function cadastrar() {
    fetch("http://localhost:8080/usuarios", 
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: iNome.value,
                email: iEmail.value,
                senha: iSenha.value,
                telefone: iTel.value
            })

        })
        .then(function(res) { 
            errorMessage.style.display = 'block';
            console.log(res)
        })
        .catch(function(res) { 
            successMessage.style.display = 'block';
            console.log(res)
        })
}

function limpar() {
    iNome.value = "";
    iEmail.value = "";
    iSenha.value = "";
    iTel.value = "";
}

formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    cadastrar();
    // limpar();
});

// console.log(formulario)