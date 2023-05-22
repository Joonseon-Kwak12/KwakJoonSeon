<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/head.jspf"%>
<%@ include file="../common/nav.jspf"%>


<div class="h-24"> 
<!-- 빈 공간 -->
</div>

<section id="schedule" class="mx-auto w-10/12 bg-white">

	<div class="col-span-7 flex justify-center gap-10">
		<div><a href="javascript:;" class="go-prev">&lt;</a></div>
		<div class="year-month"></div>
		<div><a href="javascript:;" class="go-next">&gt;</a></div>
	</div>
	
	<div class="days grid grid-cols-7">
		<div class="day text-center">월</div>
		<div class="day text-center">화</div>
		<div class="day text-center">수</div>
		<div class="day text-center">목</div>
		<div class="day text-center">금</div>
		<div class="day text-center">토</div>
		<div class="day text-center">일</div>
	</div>
	<div class="dates grid grid-cols-7"></div>
	
</section>


<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function(){
	scheduleInit();
})

/*
	달력 렌더링할 때 필요한 정보 목록
	- 현재 월(초기값: 현재 시간)
	- 이번 달 마지막일 날짜와 요일
	- 이전 달 마지막일 날짜와 요일
*/
function scheduleInit() {
	// 날짜 정보 가져오기
	let date = new Date(); //로컬 현재 날짜 가져오기
	let utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); //utc 표준 시 도출
	let kstGap = 9 * 60 * 60 * 1000; //한국 kst 기준시간 더하기
	let today = new Date(utc + kstGap); //한국 시간으로 date 객체 만들기(오늘)
	
	let thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate()); //달력에서 표기하는 날짜 객체

	let currentYear = thisMonth.getFullYear(); //달력에서 표기하는 년
	let currentMonth = thisMonth.getMonth(); //달력에서 표기하는 월
	let currentDate = thisMonth.getDate(); //달력에서 표기하는 일
	
	renderSchedule(thisMonth);
	 
	function renderSchedule(thisMonth) {
		 
		//렌더링을 위한 변수에 데이터 할당
		//currentYear = thisMonth.getFullYear();
		//currentMonth = thisMonth.getMonth();
		//currentDate = thisMonth.getDate();
		
		//이전 달의 마지막 날 날짜와 요일 구하기
		let startDay = new Date(currentYear, currentMonth, 0);
		let prevDate = startDay.getDate();
		let prevDay = startDay.getDay();
		
		//이번 달의 마지막 날 날짜와 요일 구하기
		let endDay = new Date(currentYear, currentMonth + 1, 0);
		let nextDate = endDay.getDate();
		let nextDay = endDay.getDay();
		
		//현재 월 표기
		//아마 수정 필요할 것 //일단 주석 처리
		document.querySelector('.year-month').textContent = currentYear + '.' + (currentMonth + 1);
		
		//렌더링 html 요소 생성
		let schedule = document.querySelector('.dates')
		schedule.innerHTML = ' ';
		
		//이전 달
		for (let i = prevDate - prevDay + 1; i <= prevDate; i ++) {
			schedule.innerHTML = schedule.innerHTML + '<div class="day prev disable">' + i + '</div>';
		}
		//이번 달
		for (let i = 1; i <= nextDate; i++) {
			schedule.innerHTML = schedule.innerHTML + '<div class="day current">' + i + '</div>';
		}
		//다음 달
		for (let i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
			schedule.innerHTML = schedule.innerHTML + '<div class="day next disable">' + i + '</div>';
		}
		
		//오늘 날짜 강조
		if (today.getMonth() == currentMonth) {
			let todayDate = today.getDate();
			let currentMonthDate = document.querySelectorAll('.dates .current');
			currentMonthDate[ todayDate - 1 ].classList.add('today');
		}
		
	 }
	 
	 //이전 달로 이동
	 document.querySelector('.go-prev').addEventListener('click', function() {
		 thisMonth = new Date(currentYear, currentMonth - 1, 1);
		 renderSchedule(thisMonth);
	 });
	 //다음 달로 이동
	 document.querySelector('.go-next').addEventListener('click', function() {
		 thisMonth = new Date(currentYear, currentMonth + 1, 1);
		 renderSchedule(thisMonth);
	 });
	
}
</script>


<%@ include file="../common/footer.jspf"%>
