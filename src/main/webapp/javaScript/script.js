let show = true;
let openShopping = document.querySelector('.shopping');
let closeShopping = document.querySelector('.closeShopping');
let list = document.querySelector('.list');
let listCard = document.querySelector('.listCard');
let body = document.querySelector('body');
let total = document.querySelector('.total');
let quantity = document.querySelector('.quantity');

openShopping.addEventListener('click', ()=>{
    body.classList.add('active');
})
closeShopping.addEventListener('click', ()=>{
    body.classList.remove('active');
})

let products = [
    {
        id: 1,
        name: 'PIZZA CALABRESA',
        image: 'pizza_1.PNG',
        price: 120000
    },
    {
        id: 2,
        name: 'PIZZA PORTUGUESA',
        image: 'pizza_2.PNG',
        price: 120000
    },
    {
        id: 3,
        name: 'PIZZA MARGUERITA',
        image: 'pizza_3.PNG',
        price: 220000
    },
    {
        id: 4,
        name: 'PIZZA 4 QUEIJOS',
        image: 'pizza_4.PNG',
        price: 123000
    },
    {
        id: 5,
        name: 'PIZZA FRANGO',
        image: 'pizza_5.PNG',
        price: 320000
    },
    {
        id: 6,
        name: 'PIZZA CHOCOLATE',
        image: 'pizza_6.PNG',
        price: 120000
    },
    {
        id: 7,
        name: 'PIZZA PEPERONI',
        image: 'pizza_7.PNG',
        price: 120000
    },
    {
        id: 8,
        name: 'PIZZA SALMÃO',
        image: 'pizza_8.PNG',
        price: 120000
    }
];

let listCards  = [];
function initApp(){
    products.forEach((value, key) =>{
        let newDiv = document.createElement('div');
        newDiv.classList.add('item');
        newDiv.innerHTML = `
            <img src="./img/${value.image}">
            <div class="title">${value.name}</div>
            <div class="price">${value.price.toLocaleString()}</div>
            <button onclick="addToCard(${key})">Adicionar ao carrinho</button>`;
        list.appendChild(newDiv);
    })
}
initApp();
function addToCard(key){
    if(listCards[key] == null){
        // copy product form list to list card
        listCards[key] = JSON.parse(JSON.stringify(products[key]));
        listCards[key].quantity = 1;
    }
    reloadCard();
}
function reloadCard(){
    listCard.innerHTML = '';
    let count = 0;
    let totalPrice = 0;
    listCards.forEach((value, key)=>{
        totalPrice = totalPrice + value.price;
        count = count + value.quantity;
        if(value != null){
            let newDiv = document.createElement('li');
            newDiv.innerHTML = `
                <div><img src="./img/${value.image}"/></div>
                <div>${value.name}</div>
                <div>${value.price.toLocaleString()}</div>
                <div>
                    <button onclick="changeQuantity(${key}, ${value.quantity - 1})">-</button>
                    <div class="count">${value.quantity}</div>
                    <button onclick="changeQuantity(${key}, ${value.quantity + 1})">+</button>
                </div>`;
                listCard.appendChild(newDiv);
        }
    })
    total.innerText = totalPrice.toLocaleString();
    quantity.innerText = count;
}
function changeQuantity(key, quantity){
    if(quantity == 0){
        delete listCards[key];
    }else{
        listCards[key].quantity = quantity;
        listCards[key].price = quantity * products[key].price;
    }
    reloadCard();
}
//variavel que vai receber o elemento content la do html
const menuContent = document.querySelector('.content');
//entra na variavel que acabou de ser criada para acessar o menu-toggle
const menuToggle = menuContent.querySelector('.menu-toggle');

//Fazendo as operações para usar o menu
menuToggle.addEventListener('click', () => {
    menuContent.classList.toggle('on', show);
    show =!show; //invertendo o valor da variavel show para alternar o estado do menu  
});



