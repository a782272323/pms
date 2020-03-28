package learn.lhb.pms.admin;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import learn.lhb.pms.commons.utils.MapperUtils;
import learn.lhb.pms.mapper.rbac.TbResourcesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @author 梁鸿斌
 * @date 2020/3/26.
 * @time 00:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest(value = "PmsAdminApplication.class")
public class JsonTreeControllerTest {

    @Resource
    private TbResourcesMapper tbResourcesMapper;

    /**
     * 递归查询
     */
    @Test
    public void getResourcesTreeTest() throws Exception {
        List<Map<String, Object>> resources = tbResourcesMapper.getResourcesTree("ROLE_ADMIN");
        System.out.println(MapperUtils.obj2json(resources));
    }

    /**
     * 根据角色名获取资源参数来做路由表
     */
    @Test
    public void getRouteByRoleNameTest() throws Exception {
//        List<Map<String, Object>> resources = tbResourcesMapper.getRouteByRoleName("ROLE_ADMIN");
        List<Map> resources = tbResourcesMapper.getRouteByRoleName("ROLE_ADMIN");
        String[] strings = new String[resources.size()];
        for (int i = 0; i < resources.size(); i++) {
//            strings[i] = resources.
        }
        System.out.println(MapperUtils.obj2json(resources));

//        List<Map> selectAll = resources;
//        List linkList = Lists.newArrayList();
//        Map linkMap = Maps.newLinkedHashMap();
//        for (Map entity : selectAll) {
//            Integer id = (Integer) entity.get("id");
//            linkMap.put(id, entity);
//        }
//        int size = selectAll.size();
//        for (int i = 0; i < size; i++) {
//            Map entity = selectAll.get(i);
//            Integer parent_id = (Integer) entity.get("parent_id");
//            Map parentMap = (Map) linkMap.get(parent_id);
//            if (parentMap != null) {
//                List childrenList = (List) parentMap.get("children");
//                if (childrenList != null) {
//                    childrenList.add(entity);
//                } else {
//                    ArrayList<Object> arrayList = new ArrayList<>();
//                    arrayList.add(entity);
//                    parentMap.put("children",arrayList);
//                }
//            } else {
//                linkList.add(entity);
//            }
//
//            Map<String,Object> map = Maps.newHashMap();
//            map.clear();
//            map.put("data", linkList);
//        }
//        System.out.println("TreeJson = ");
//        System.out.println(MapperUtils.obj2json(selectAll));
    }

//    private List<Map> data() {
//        List linkList = new LinkedList();
//        Map data = tbResourcesMapper.getRouteByRoleName("ROLE_ADMIN");
//        linkList.add(data);
//        return linkList;
//    }

    @Test
    public void testJsonTreeOne() throws Exception {
        List<Map> selectAll = buildData();
        List linkList = Lists.newArrayList();
        Map linkMap = Maps.newHashMap();
        for (Map entity : selectAll) {
            Integer id = (Integer) entity.get("id");
            linkMap.put(id, entity);
        }
        int size = selectAll.size();
        for (int i = 0; i < size; i++) {
            Map entity = selectAll.get(i);
            Integer pid = (Integer) entity.get("pid");
            Map parentMap = (Map) linkMap.get(pid);
            if (parentMap != null) {
                List childrenList = (List) parentMap.get("children");
                if (childrenList != null) {
                    childrenList.add(entity);
                } else {
                    // todo 百度 ArrayList
                    ArrayList<Object> arrayList = new ArrayList<>();
                    arrayList.add(entity);
                    parentMap.put("children", arrayList);
                }
            } else {
                linkList.add(entity);
            }

            Map<String,Object> map = Maps.newHashMap();
            map.clear();
            map.put("data", linkList);

        }

        System.out.println("TreeJson = " + MapperUtils.obj2json(selectAll));
    }

    private List buildData() {
        List linkList = new LinkedList<>();
        Map data1 = new LinkedHashMap<>();
        data1.put("id",1);
        data1.put("pid",0);
        data1.put("name","t1");
        linkList.add(data1);

        data1=new LinkedHashMap<>();
        data1.put("id", 2);
        data1.put("pid", 0);
        data1.put("name", "t2");
        linkList.add(data1);

        data1=new LinkedHashMap<>();
        data1.put("id", 3);
        data1.put("pid", 1);
        data1.put("name", "t11");
        linkList.add(data1);

        data1=new LinkedHashMap<>();
        data1.put("id", 4);
        data1.put("pid", 3);
        data1.put("name", "t111");
        linkList.add(data1);

        return linkList;
    }


    /**
     * pojo2map
     * @param object
     * @return
     */
//    private Map<String, Object> object2Map(Object object) {
//        Map<String,Object> result = Maps.newHashMap();
//        // 获得类的属性名 数组
//        Field[] fields = object.getClass().getDeclaredFields();
//        try {
//            for (Field field : fields) {
//                field.setAccessible(true);
//                String name = new String(field.getName());
//                result.put(name, field.get(object));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}
