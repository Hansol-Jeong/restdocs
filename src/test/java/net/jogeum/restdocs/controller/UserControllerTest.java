package net.jogeum.restdocs.controller;

import net.jogeum.restdocs.ApiDocTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author jogeum
 * @since 2019-08-03
 */
public class UserControllerTest extends ApiDocTest {
    private String TEST_URL = "/v1/users";

    @Test
    public void getList() throws Exception {
        //given

        //when
        ResultActions result = mockMvc.perform(get(TEST_URL));

        //then
        result.andExpect(status().isOk())
                .andDo(print())
                .andDo(document.document(
                        responseFields(
                                fieldWithPath("[]").description("사용자 리스트"),
                                fieldWithPath("[].id").description("사용자 id"),
                                fieldWithPath("[].name").description("사용자 이름"),
                                fieldWithPath("[].email").description("사용자 이메일")
                        )
                ))
                .andReturn();
    }

    @Test
    public void getUser() throws Exception {
        //given

        //when
        ResultActions result = mockMvc.perform(get(TEST_URL + "/{userId}", "jogeum"));

        //then
        result.andExpect(status().isOk())
                .andDo(print())
                .andDo(document.document(
                        pathParameters(
                                parameterWithName("userId").description("조회할 대상자 id")
                        ),
                        responseFields(
                                fieldWithPath("id").description("사용자 id"),
                                fieldWithPath("name").description("사용자 이름"),
                                fieldWithPath("email").description("사용자 이메일")
                        )
                ))
                .andReturn();
    }
}