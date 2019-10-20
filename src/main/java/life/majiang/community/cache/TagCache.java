package life.majiang.community.cache;

import life.majiang.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("javscript","php","css","html","html5","java","ode.js","python","c++","c","golang","objetive-c","typscript","shell","swift","c#","sass","ruby","bash","less","sp.net","lua","scala","coffescript","actioscript","rust","erlang","perl"));
        tagDTOS.add(program);

        TagDTO framwork = new TagDTO();
        framwork.setCategoryName("平台框架");
        framwork.setTags(Arrays.asList("laravel","spring","express","django","flask","yii","ruby-on-rails","tornado","koa","struts"));
        tagDTOS.add(framwork);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","apache","ubuntu","centos","缓存 tomcat","负载均衡","unix","hadoop","windows-server"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql","redis","mongodb","sql","oracle","nosql","memcached","sqlserver","postgresql","sqlite"));
        tagDTOS.add(db);
        return tagDTOS;
   }

   public static String filterInvalic(String tags){
       String[] split = StringUtils.split(tags, ",");
       List<TagDTO> tagDTOS = get();
       List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
       String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
       return invalid;

   }
}
