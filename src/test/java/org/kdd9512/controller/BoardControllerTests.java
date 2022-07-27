package org.kdd9512.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // controller 테스팅을 위해 필요함.
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/root-context.xml",
        "file:src/main/webapp/WEB-INF/servlet-context.xml"})
@Log4j
public class BoardControllerTests {

    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testList() throws Exception { // try ~ catch 대신에 그냥 여기서 처리.

        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap());

    }

    @Test
    public void testRegister() throws Exception { // try ~ catch 대신에 그냥 여기서 처리.

        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "등록 테스트 제목")
                .param("content", "등록 테스트 내용")
                .param("writer", "등록 테스트 작가"))
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info("RESULT PAGE : [ " + resultPage + " ]");
    }

    @Test
    public void testGet() throws Exception {

        log.info(mockMvc.perform(MockMvcRequestBuilders
                .get("/board/get")
                .param("bno", "2"))
                .andReturn()
                .getModelAndView()
                .getModelMap());

    }

    @Test
    public void testModify() throws Exception {

        String resultPage = mockMvc
                .perform(MockMvcRequestBuilders.post("/board/modify")
                .param("bno", "1")
                .param("title", "수정한 테스트 글의 제목")
                .param("content", "수정한 테스트 글의 내용")
                .param("writer", "user123"))
                .andReturn().getModelAndView().getViewName();

        log.info("RESULT PAGE : [ " + resultPage + " ]");

    }

    @Test
    public void testRemove() throws Exception {

        String resultPage = mockMvc.perform(MockMvcRequestBuilders
                .post("/board/remove")
                .param("bno", "45"))
                .andReturn().getModelAndView().getViewName();

        log.info("RESULT PAGE (AFTER REMOVE): [ " + resultPage + " ]");

    }

    @Test
    public void testListPaging() throws Exception {

        log.info(mockMvc.perform(
                MockMvcRequestBuilders.get("/board/list")
                        .param("pageNum", "2")
                        .param("amount", "50"))
                .andReturn().getModelAndView().getModelMap());

    }

}
