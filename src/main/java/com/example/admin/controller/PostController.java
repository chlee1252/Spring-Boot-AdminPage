package com.example.admin.controller;

import com.example.admin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    //HTML <form>
    // ajax 검색
    // http post body -> data
    // json, xml, multipart-form / text-plain

    // @RequestMapping(method = RequestMethod.POST, path = "postMethod")
    // produces 를 사용해서 어떤 방식으로 데이터를 받아올지 설정 할 수 있다.
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

    @PutMapping("/putMapping")
    public void put() {

    }

    @PatchMapping("/patchMapping")
    public void patch() {

    }
}
