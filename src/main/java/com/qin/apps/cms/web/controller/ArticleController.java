package com.qin.apps.cms.web.controller;

import com.qin.apps.cms.bean.Article;
import com.qin.apps.cms.bean.extend.ArticleExtend;
import com.qin.apps.cms.service.IArticleService;
import com.qin.apps.cms.utils.ExcelUtils;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description ="文章相关接口")
@RestController
@RequestMapping("/ArticleController")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @ApiOperation(value="将文章导入到Excel中",notes="注意！测试的时候请将地址粘贴到浏览器地址栏测试",produces="application/octet-stream")
    @GetMapping("download")
    public void download(HttpServletResponse response) throws Exception{
        // 查询出所有文章信息
        String excelName = "article_list";
        String[] headList = new String[]{"编号","标题","内容"};
        String[] fieldList = new String[]{"id","title","content"};
        List<Map<String, Object>> dataList = new ArrayList<>();
        List<Article> list =articleService.findAllArticle();
        for(Article a : list){
            Map<String, Object> map = new HashMap<>();
            map.put("id",a.getId());
            map.put("title",a.getTitle());
            map.put("content",a.getContent());
            dataList.add(map);
        }

        //调用工具类导出excel
        ExcelUtils.createExcel(response,excelName,headList,fieldList,dataList);

    }
    @ApiOperation("更行或修改")
    @PostMapping("saveOrUpdateArticle")
    public Message saveOrUpdateArticle(
                            @ApiParam(value = "编号") @RequestParam(value="id",required = false) Long id,
                            @ApiParam(value = "标题",required = true) @RequestParam(value="title") String title,
                            @ApiParam(value = "内容",required = true) @RequestParam(value="content") String content,
                            @ApiParam(value = "源内容") @RequestParam(value="source",required = false) String source,
                            @ApiParam(value = "栏目ID",required = true) @RequestParam(value="categoryId") Long categoryId,
                            @ApiParam(value = "作者ID") @RequestParam(value="authorId",required = false) Long authorId){
        Article article = new Article();
            article.setId(id);
            article.setTitle(title);
            article.setContent(content);
            article.setSource(source);
            article.setCategoryId(categoryId);
            article.setAuthorId(authorId);
        articleService.saveOrUpdateArticle(article);
        return MessageUtil.success("更新成功！");
    }
    @ApiOperation("单表查询所有")
    @GetMapping("findAllArticle")
    public Message findAllArticle(){
        List<Article> articles= articleService.findAllArticle();
        return MessageUtil.success("单表查询成功",articles);
    }
    @ApiOperation("级联查询所有")
    @GetMapping("cascadeFindAllArticle")
    public Message cascadeFindAllArticle(){
        List<ArticleExtend> articleExtends = articleService.cascadeFindAllArticle();
        return MessageUtil.success("级联查询成功",articleExtends);
    }
    @ApiOperation("通过ID级联查询")
    @GetMapping("findArticleById")
    public Message findArticleById(Long id){
        ArticleExtend articleExtend = articleService.findArticleById(id);
        return MessageUtil.success("级联查询成功",articleExtend);
    }
    @ApiOperation("通过ID删除文章")
    @PostMapping("deleteArticleById")
    public Message deleteArticleById(@RequestBody  List<Long> ids){
        articleService.deleteArticleById(ids);
        return MessageUtil.success("删除成功！");
    }

}
