package com.cloud.study.ztree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 37300 on 2017/7/13.
 */
@Controller
@RequestMapping("ztree")
public class ZTreeTestController {

    @RequestMapping(value = "/to-test-ztree")
    public String toTestZTree() {
        return "zTreeTest.html";
    }

    @RequestMapping(value = "/to-async-ztree")
    public String toAsyncZTree() {
        return "zTreeAsyncTest.html";
    }

    /**
     * 获取树形结点数据
     * @return
     */
    @GetMapping(value = "/getTree")
    @ResponseBody
    public List<ZTreeNode> getTree(Long id) {
        List<ZTreeNode> result = new ArrayList<ZTreeNode>();

        if (id == null) {
            result.add(buildZTreeNode(1L, "1", true));
            result.add(buildZTreeNode(2L, "2", true));
        } else if (id == 1) {
            result.add(buildZTreeNode(11L, "11", false));
            result.add(buildZTreeNode(12L, "12", false));
            result.add(buildZTreeNode(13L, "13", false));
        } else if (id == 2) {
            result.add(buildZTreeNode(21L, "21", false));
            result.add(buildZTreeNode(22L, "22", false));
            result.add(buildZTreeNode(23L, "23", false));
        }

        return result;
    }

    private ZTreeNode buildZTreeNode(Long id, String name, boolean isPrent) {
        ZTreeNode node = new ZTreeNode();

        node.setId(id);
        node.setName(name);
        node.setIsParent(isPrent);

        return node;
    }

}
