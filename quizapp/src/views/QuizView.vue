<script setup>
    import {useRoute} from "vue-router"; 
    import {ref, watch, computed} from "vue"
    import Question from "../components/Question.vue"
    import QuizHeader from "../components/QuizHeader.vue"
    import Result from "../components/Result.vue"
    import q from "../data/quizes.json"
    
    const route = useRoute()

    const quizId = parseInt(route.params.id)
    
    const quiz = q.find(q => q.id ===quizId)
    
    const currentQuestionIndex = ref(0)

    const numberOfCorrectAnswers = ref(0)

    const showResults = ref(false)
    // const questionStatus = ref(`${currentQuestionIndex.value}/${quiz.questions.length}`)
    // watch(() => currentQuestionIndex.value, () => {
    //     questionStatus.value = `${currentQuestionIndex.value}/${quiz.questions.length}`
    // })

    const questionStatus = computed( () => {
        return `${currentQuestionIndex.value}/${quiz.questions.length}`
    })

    const barPercentage = computed( () => {
        return `${currentQuestionIndex.value/quiz.questions.length * 100}%`
    })

    const onOptionSelected = (isCorrect) => {
        if(isCorrect) {
            numberOfCorrectAnswers.value++;
        }

        if(quiz.questions.length -1 === currentQuestionIndex.value) {
            showResults.value = true
        }

        currentQuestionIndex.value++

    }
</script>

<template>
    <div>
        <QuizHeader 
            :questionStatus="questionStatus" 
            :barPercentage="barPercentage"
        />
        <div>
            <Question 
                v-if="!showResults"
                :question="quiz.questions[currentQuestionIndex]"
                @selectOption="onOptionSelected"
            
            /> 

            <Result 
                v-else
                :quizQuestionLength="quiz.questions.length"
                :numberOfCorrectAnswers="numberOfCorrectAnswers"
            />
        </div>
    </div>
</template>

<style scoped>

/* 
watch: 주로 비동기 로직이 필요하거나, 데이터 감지에 대한 세밀한 제어가 필요한 경우 사용합니다.
computed: 주로 데이터를 기반으로 한 값을 계산하거나, 캐싱된 값을 사용하여 성능을 개선하고자 할 때 사용합니다. Setter 로직이 필요한 경우에도 유용합니다.


watch:
    비동기 또는 비교 로직이 필요한 경우:
    watch는 비동기 로직을 수행하거나 특정 데이터의 변경을 비교하고자 할 때 유용합니다. 예를 들어 API 호출 후 데이터를 업데이트하거나, 특정 데이터의 변경을 감지하고 특정 동작을 수행하려는 경우에 사용됩니다.



computed:
    파생된 데이터 계산이 필요한 경우:
    computed는 기존 데이터를 기반으로 새로운 데이터를 계산하고 싶을 때 사용됩니다. 이는 종종 특정 데이터의 변화에 의존하는 값을 계산하거나 복잡한 계산 로직을 단순화하고 가독성을 높일 때 유용합니다.

    캐싱된 데이터 필요한 경우:
    computed는 결과를 캐싱하여 성능을 향상시킬 수 있습니다. 같은 입력 값에 대해 여러 번 호출되더라도 실제 계산은 최초 호출 시에만 이루어지며, 그 후에는 캐싱된 값을 반환합니다.

    Setter 로직이 필요한 경우:
    computed는 값의 변경 또는 할당에 대한 로직을 지원합니다. 만약 계산된 값에 대한 변경을 감지하고자 하는 경우 set 함수를 사용할 수 있습니다.

*/

 
</style>