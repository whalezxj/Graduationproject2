package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @date 2020/9/7
 **/


   /* @RequestMapping("export")
    public static void export(HttpServletRequest request, HttpServletResponse responseon) throws Exception {
        String template = "/test1.xlsx";
        OutputStream os = new FileOutputStream("E://DDesktop/out.xls");//换成指定文件 出现错误    不换 下载下来是压缩包
        List<User> users = new ArrayList<>();
        User user1 = new User(1,"1","1");
        User user2 = new User(2,"1","1");
        User user3 = new User(3,"1","1");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        template = ExcelTest.class.getResource(template).getPath();
        HashMap<String, Object> model = new HashMap<>();
        model.put("user", users);

        JxlsUtils.exportExcel(template,responseon.getOutputStream(),model);
        System.out.println("完成");

    }*/

@Controller
@RequestMapping("/test")
@Slf4j
public class ExcelTest {

    /*public static String template = "/test1.xlsx" ;

    public static void main(String[] args) throws IOException {
        execute();
    }
    public static void execute() throws IOException {
        log.info("Opening input stream");
        OutputStream os = new FileOutputStream("E://DDesktop/out.xlsx");//换成指定文件 出现错误    不换 下载下来是压缩包
        List<User> users = new ArrayList<>();
        User user1 = new User(1,"1","1");
        User user2 = new User(2,"1","1");
        User user3 = new User(3,"1","1");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        template = ExcelTest.class.getResource(template).getPath();
        HashMap<String, Object> model = new HashMap<>();
        model.put("user", users);
        //template 为模板路径：eg:leadshow.xls，
        // JxlsExporter.class.getResourceAsStream(template)—> leadshow.xls模板路径需放置在该类包路径下
        String path = new File("").getAbsolutePath()+"/src/main/resources/test1.xlsx";
        try (InputStream is = new FileInputStream(path)) {
            //output 为导出的Excel路径，有一个坑需要注意的是，在springboot项目打包成jar包之后，
            //导出文件路径可这样表示： System.getProperty("user.dir") + "/export_leadshow.xls"，这种"static/export_leadshow.xls"路径会失效
                Context context = new PoiContext();
                context.putVar("user", users);
                JxlsHelper.getInstance().processTemplate(is, os, context);
        }
    }*/

}
