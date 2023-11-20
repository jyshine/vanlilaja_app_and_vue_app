<script setup>
  import {ref} from "vue";

  const showModal = ref(false)
  const newNote = ref("")
  const notes = ref([])
  const errorMessage = ref("")

  function getRandomColor() {
    return 'hsla(' + (Math.random() * 360) + ', 100%, 70%, 1)';
}
function formatTime(time, prefix = "") {
    return typeof time == "object" ? prefix + time.toLocaleDateString() : "";
}
  const addNote = (() => {
    if(newNote.value.length < 10 ) {
      return errorMessage.value = "Note need to be 10 characters or more "
    }

    notes.value.push({
      id: Math.floor(Math.random()*1000000),
      text: newNote.value,
      date: new Date(),
      backgroundColor: getRandomColor()
    })
    showModal.value = false
    newNote.value = ""
    errorMessage.value = ""
  })

</script>
<template>
  <main>
    <div class="container">
      <div v-if="showModal" class="overlay">
        <div class="modal">
          <textarea v-model.trim="newNote" name="note" id="note" cols="30" rows="10"></textarea>
          <p v-if="errorMessage">{{errorMessage}}</p>
          <button @click="addNote">Add Note</button>
          <button @click="showModal = false" class="close">Close</button>
        </div>
      </div>
      <header>
        <h1>Notes</h1>
        <button @click="showModal = true">+</button>
      </header>
      <div class="cards-container">
        <div  v-for="note in notes" :key="note.id" class="card" :style="{backgroundColor:note.backgroundColor}">
          <p class="mian-text">{{note.text}}</p>
          <p class="date">{{formatTime(note.date)}}</p>
        </div>
      </div>
    </div>
  </main>
</template>

<style scoped>
  .container {
    max-width: 1000px;
    padding: 10px;
    margin: 0 auto
  }

  h1 {
    font-weight: bold;
    margin-bottom: 25px;
    font-size: 75px;
  }

  .card {
    width: 225px;
    height: 225px;
    background-color: rgb(237, 182, 44);
    padding: 10px;
    border-radius: 15px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    margin-right: 20px;
    margin-bottom: 20px;
  }

  .main-text {
    line-height: 1.25;
    font-size: 17.5px;
    font-weight: bold;
  }

  .date {
    font-size: 12.5px;
    margin-top: auto;
  }

  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  header button {
    border: none;
    padding: 10px;
    width: 50px;
    height: 50px;
    cursor: pointer;
    background-color: rgb(21, 20, 20);
    border-radius: 1000px;
    color: white;
    font-size: 20px;
  }
  .cards-container {
    display: flex;
    flex-wrap: wrap;
  }

  .overlay {
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.77);
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 10;
  }

  main {
    height: 100vh;
    width: 100vw;
  }

  .modal {
    width: 750px;
    background-color: white;
    border-radius: 10px;
    padding: 30px;
    position: relative;
    display: flex;
    flex-direction: column;
  }

  .modal button {
    padding: 10px 20px;
    font-size: 20px;
    width: 100%;
    background-color: blueviolet;
    border: none;
    color: white;
    cursor: pointer;
    margin-top: 15px;

  }

  .modal .close {
    background-color: rgb(193,15,15);
    margin-top: 7px;
  }

  .modal p {
    color: red;
    margin-left: auto;
    font-size: 20px;
    z-index: 100000;
    cursor: pointer;
  }

  textarea {
    width: 100%;
    height: 200px;
    padding: 5px;
    font-size: 20px;
  }
</style>