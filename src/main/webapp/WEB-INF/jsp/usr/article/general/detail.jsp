<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../common/head.jspf"%>
<%@ include file="../../common/nav.jspf"%>



	<section class="mt-8 text-l">
		<div class="container mx-auto px-3">
		
			<div class="w-10/12 mx-auto">
			
				<header class="h-10">${articleData.title }</header>
				<div class="flex my-2 justify-around text-sm">
					<div>글번호: ${articleData.id }</div>
					<div>${articleData.regDate.substring(0,16) }</div>
					<div>${articleData.memberId }</div>
				</div>
				
				<div class="h-px bg-amber-200"></div>
				
				<article>
					<div class="my-2 min-h-[300px]">${articleData.body}</div>
				</article>
				
				<div class="h-px bg-amber-200"></div>

				<div class="flex justify-end gap-x-5">
					<div><a href="/article/${articleData.id }/modify">수정</a></div>
					<div><form action="/article/${articleData.id }/delete" method="post"><button>삭제</button></form></div>
					<div><a href="#">뒤로가기</a></div>
				</div>

				<div id="reply-part">
					<div id="reply-write-window" class="mt-6 border-y border-solid border-amber-200">
						<form action="../reply/doWrite" method="post" onsubmit="ReplyWrite__submitForm(this); return false;"
							class="flex p-2 gap-4">
							<input type="hidden" name="relId" value="${article.id }" />
							<input type="hidden" name="relTypeCode" value="article" />
							<input type="hidden" name="replaceUri" value="${rq.currentUri }" />
							<div>댓글</div>
							<c:choose>
								<c:when test="${rq.isLogined() }">
									<textarea placeholder="댓글 내용을 입력해주세요." name="body" rows="3"
										class="rounded resize-none grow border border-solid border-gray-400"></textarea>
								</c:when>
								<c:when test="${!rq.isLogined() }">
									<div class="rounded resize-none grow border border-solid border-gray-400 h-16">
										<a href="../member/login?afterLoginUri=${rq.loginUri }" class="text-blue-500">로그인</a>
										<span> 후 이용 가능합니다.</span>
									</div>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${rq.isLogined() }">
									<button type="submit" class="w-24 h-6 border-solid border-gray-400 bg-black text-white text-sm rounded">댓글쓰기</button>
								</c:when>
								<c:when test="${!rq.isLogined() }">
									<button disabled="disabled" type="submit"
										class="w-24 <h></h>-6 border-solid border-gray-400 bg-black text-white text-sm rounded">댓글쓰기</button>
								</c:when>
							</c:choose>
						</form>
					</div>
					<div id="reply-list">
						<ul class="divide-y divide-amber-200">
							<c:forEach var="reply" items="${replies }">
								<li>
									<div class="flex gap-x-11 my-2 justify-around text-base">
										<div>${reply.extra__writer }</div>
										<div>${reply.regDate.substring(0,16) }</div>
									</div>
									<div class="my-2 w-5/6 inline-block">
										<div class="break-all">${reply.body }</div>
									</div>
									<div class="inline-block mx-2 px-2]">
										<c:if test="${reply.actorCanModify }">
											<a href="../reply/modify?id=${reply.id }&replaceUri=${rq.encodedCurrentUri}">수정</a>
										</c:if>
									</div>
									<div class="inline-block mx-2 px-2">
										<c:if test="${reply.actorCanDelete }">
											<a onclick="if(confirm('정말 삭제하시겠습니까?')==false) return false;"
												href="../reply/doDelete?id=${reply.id }&replaceUri=${rq.encodedCurrentUri}">삭제</a>
										</c:if>
									</div>
	
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>

		</div>
			
		</div>
	</section>

<%@ include file="../../common/footer.jspf"%>