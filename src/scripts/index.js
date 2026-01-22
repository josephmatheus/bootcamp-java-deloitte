const form = document.querySelector(".form");
const btn = document.querySelector(".btn");
const mensagem = document.querySelector(".mensagem")

form.addEventListener("submit", (event) => {
    event.preventDefault()
    const inputName = document.getElementById("inputName");
    const name = inputName.value;
    btn.innerHTML = "Enviado!"
    btn.classList.remove('btn-primary')
    btn.classList.add('btn-success')
    mensagem.innerHTML = `
    Olá, <span>${name}</span>!<br>Seja bem-vindo ao bootcamp Deloitte.
    `

    setTimeout(() => {
        btn.innerHTML = "Enviar"
        btn.classList.remove('btn-success')
        btn.classList.add('btn-primary')
        inputName.value = ""
        mensagem.innerHTML = ""
    }, 3000);
});
