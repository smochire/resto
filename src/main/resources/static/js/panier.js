showPanier();
let produits = document.querySelectorAll(".product-item");
produits.forEach((produit)=>
    produit.children[0].children[1].children[0].addEventListener('click',()=>
    {
        let prix =  produit.querySelector(".product-price").innerHTML;
        let nom = produit.querySelector(".nom").innerHTML;
        let panier = localStorage.getItem("panier");
        if(panier==null)
        {
            paniers = [];
        }else{
            paniers = JSON.parse(panier);
        }
        let pa = {nom:nom,prix:prix,quantite:1};
        let foundPa = paniers.find(p=>p.nom==pa.nom);
        if(foundPa!=undefined)
        {
            foundPa.quantite++;
        }else{
            paniers.push(pa);
        }

        localStorage.setItem("panier", JSON.stringify(paniers));

        showPanier();
        nombre();
    }),
)
function vider() {
    localStorage.removeItem("panier");
}
function nombre() {
    let panier = localStorage.getItem("panier");
    let paniers = JSON.parse(panier);
    let pan = document.getElementById("logoPanier");
    pan.innerText =  paniers.length;
}
function showPanier() {
    let panier = localStorage.getItem("panier");
    if(panier==null)
    {
        paniers = [];
    }else{
        paniers = JSON.parse(panier);
    }
    let html="";
    let somme = 0.0;
    let  affiche = document.getElementById("panier");
    paniers.forEach((item,index)=>{
        let prix = item.prix.replace(/[^0-9\\.]+/g, '');
        let mont = parseInt(item.quantite)*parseInt(prix);
        html +=`	<li class="prod clearfix ">
	                        <input type="hidden" name="nom" value="${item.nom}"/>
	                        <input type="hidden" name="quantite" value="${item.quantite}"/>
	                        <input type="hidden" name="prix" value="${mont}"/>
							<div class="pull-left">
								<div class="update-product">
									<button title="Minus a product"  onclick="soustract(${index})"><i class="fa fa-minus-circle"></i></button>
									<span class="quant" name="quantite"> ${item.quantite}</span>
									<button title="Add a product"  onclick="addition(${index})" ><i class="fa fa-plus-circle"></i></button>
								</div>
							</div>
							<div class="cart-product-name pull-left" name="nom" style="width: 300px;">${item.nom}</div>
							<div class="cart-product-price pull-right mr-15" name="prix" style="color: orangered;">${mont} €</div>
							<button type="button" class="supprimer cart-product-remove " title="Remove a product" onclick="deleteItem(${index})"><i class="fa fa-trash"></i></button>
						</li>`;

        somme +=parseInt(item.quantite)*parseInt(prix);

    });
    affiche.innerHTML = html;
    let montant = document.getElementById("montant");
    let montant2  = document.getElementById("montant2");
    montant2.value = somme;
    montant.innerText = somme+ " €";

}

function deleteItem(index){
    let panier = localStorage.getItem("panier");
    let paniers = JSON.parse(panier);
    paniers.splice(index,1);
    localStorage.setItem("panier", JSON.stringify(paniers));
    showPanier();
    nombre();
}
function soustract(index) {
    let panier = localStorage.getItem("panier");
    let paniers = JSON.parse(panier);
    if(parseInt(paniers[index].quantite)<=1)
    {
        paniers.splice(index,1);
    }else{
        paniers[index].quantite--;
    }
    localStorage.setItem("panier", JSON.stringify(paniers));
    showPanier();
}
function addition(index) {
    let panier = localStorage.getItem("panier");
    let paniers = JSON.parse(panier);
    paniers[index].quantite++;
    localStorage.setItem("panier", JSON.stringify(paniers));
    showPanier();

}