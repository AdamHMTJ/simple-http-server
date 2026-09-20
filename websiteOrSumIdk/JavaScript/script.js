var groceries = ['milk', 'Eggs', 'Cheese']



function listGroceries(){
    for (i = 0; i< groceries.length ; i++){
    console.log(groceries.at(i))
}
}
listGroceries()

document.getElementById('box').addEventListener('click', function(){
    alert('i got clicked')
})