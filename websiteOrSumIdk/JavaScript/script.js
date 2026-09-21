const text = document.getElementById('text')

const str = 'this is the test to see if this whole thing works, because I need to know'
const strArray = str.split(' ')

function timeout(ms){
 return new Promise(resolve => setTimeout(resolve, ms))
}

async function Read() {
    for(i = 0; i < strArray.length; i++){
        text.textContent = strArray[i]
        await timeout(100)
        console.log(i)
    }
}