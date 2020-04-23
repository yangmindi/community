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
        program.setCategoryName("经验分享");
        program.setTags(Arrays.asList("考研","保研","考证","实习","工作","出国留学","考公务员"));
        tagDTOS.add(program);

        TagDTO framwork = new TagDTO();
        framwork.setCategoryName("资料分享");
        framwork.setTags(Arrays.asList("课堂笔记","考研资料"));
        tagDTOS.add(framwork);

        TagDTO server = new TagDTO();
        server.setCategoryName("主题讨论");
        server.setTags(Arrays.asList("考研讨论","保研讨论","考证讨论","实习讨论","工作讨论","出国留学讨论","考公务员讨论","课堂笔记讨论","考研资料讨论"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("职业内推");
        db.setTags(Arrays.asList("内推信息"));
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
