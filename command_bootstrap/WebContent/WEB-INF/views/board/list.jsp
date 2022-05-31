<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="boardList" value="${dataMap.boardList }" />
<head></head>
<title>자유게시판</title>
<body>
<div class="card">
		<div class="card-header">
			<h2 style="text-align: center">자유게시판</h2>
		<div style="text-align: right">
			<input type="button" class="btn btn-primary" value="새글 작성"
				onclick="OpenWindow('registForm.do','게시글 등록',900,800);" style="width: 150px; margin: 20px">
		<div id="keyword" class="card-tools" style="width: 550px; text-align: right">
				<div class="input-group row">
					<!-- search bar -->
					<!-- sort num -->
					<select class="form-control col-md-3" name="perPageNum"
						id="perPageNum" onchange="list_go(1)">
						<c:set var="perpagenum" value="${pageMaker.getCri().getPerPageNum()}"/>
						<option value="10" ${cri.perPageNum ==10? "selected" : "" } >정렬개수</option>
						<option value="2" ${cri.perPageNum ==2? "selected" : "" }>2개씩</option>
						<option value="3" ${cri.perPageNum ==3? "selected" : "" }>3개씩</option>
						<option value="5" ${cri.perPageNum ==5? "selected" : "" }>5개씩</option>
					</select>

					<!-- search bar -->
					<select class="form-control col-md-3" name="searchType"
						id="searchType">
						<option value="">검색구분</option>
							<option value="tcw"  ${cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
							<option value="tc" ${cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
							<option value="cw" ${cri.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>							
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>작성자+제목+내용</option>
					</select>
					<!-- keyword -->
					<input class="form-control" type="text" name="keyword"
						placeholder="검색어를 입력하세요." value="${param.keyword }" /> <span
						class="input-group-append">
						<button class="btn btn-primary" type="button" id="searchBtn"
							data-card-widget="search" onclick="list_go(-1)">
							<i class="fa fa-fw fa-search"></i>
						</button>
					</span>
					<!-- end : search bar -->
				</div>
			</div>
		</div>
		</div>
		<div class="card-body">
			<div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12 col-md-6"></div>
					<div class="col-sm-12 col-md-6"></div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<table id="example2"
							class="table table-bordered table-hover dataTable dtr-inline"
							role="grid" aria-describedby="example2_info">
							<thead>
								<tr role="row">
									<th style="text-align: center; width: 200px"
										class="sorting sorting_asc" tabindex="0"
										aria-controls="example2" rowspan="1" colspan="1"
										aria-sort="ascending"
										aria-label="Rendering engine: activate to sort column descending">번호</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="Browser: activate to sort column ascending">제목</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="Platform(s): activate to sort column ascending"
										style="text-align: center; width: 200px">작성자</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="Engine version: activate to sort column ascending"
										style="text-align: center; width: 200px">작성일</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="CSS grade: activate to sort column ascending"
										style="text-align: center; width: 200px">조회수</th>
								</tr>
							</thead>
							<tbody>
							<c:set var ="number" value="${true}" />
								<c:choose>
								<c:when test="${not empty boardList }">
								
								<c:forEach items="${boardList}"  var ="boardlist">

								<tr>
								</tr>
								<c:if test="${number eq true }">
								<tr class="odd">
								</c:if>
								<c:if test="${number eq false }">
								<tr class="even">
								</c:if>
								
									<td class="dtr-control sorting_1" tabindex="0"
										style="text-align: center">${boardlist.bno }</td>
									<td onclick="location.href='detail?bno=${boardlist.bno }'"
										style="cursor: pointer">${boardlist.title }</td>
									<td style="text-align: center">${boardlist.writer}</td>
									<td style="text-align: center"><fmt:formatDate
											value="${boardlist.regDate }" pattern="yyyy-MM-dd" /></td>
									<td style="text-align: center">${boardlist.viewCnt }</td>
								</tr>
								<c:set var ="number" value="${!number }" />
								</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
							<td colspan='7' class="text-center">해당내용이 없습니다.</td>
									</tr>
							</c:otherwise>
								</c:choose>
							
							</tbody>
							<tfoot>
								<tr></tr>
							</tfoot>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-5">
						<div class="dataTables_info" id="example2_info" role="status"
							aria-live="polite"></div>
</div>
<div class="col-sm-12 col-md-7">
	<div class="dataTables_paginate paging_simple_numbers"
		id="example2_paginate">
		<div class="card-footer">
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>
		</div>
	</div>
</div>
				</div>
			</div>
		</div>

	</div>

</body>