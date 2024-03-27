package com.example.coreBaseTool;

import com.example.corebase.entity.*;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.constant.TypeObjects;
import com.example.corebase.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "com.example.corebase.repository"
)
public class DBGenerator implements CommandLineRunner {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private ObjectsRepository objectsRepository;

    @Autowired
    private ObjectPremiumRepository objectPremiumRepository;

    @Autowired
    private PremiumTypesRepository premiumTypesRepository;

    @Autowired
    private RoleObjectRepository roleObjectRepository;

    @Autowired
    private UserObjectRepository userObjectRepository;

    @Autowired
    private UserPremiumRepository userPremiumRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private CodeMngRepository codeMngRepository;

    @Override
    public void run(String... args) throws Exception {
        CodeMngEntity codeMngEntity = new CodeMngEntity();
        codeMngEntity.setIsActive(ActiveStatus.ACTIVE);
        codeMngEntity.setCdCategory("OBJECT_TYPE");
        codeMngEntity.setCdId("OBJECT_TYPE_1");
        codeMngEntity.setCdName("Menu");
        codeMngEntity.setCdKey("base.common.code.object.menu");
        codeMngRepository.save(codeMngEntity);

        CodeMngEntity codeMngEntity1 = new CodeMngEntity();
        codeMngEntity1.setIsActive(ActiveStatus.ACTIVE);
        codeMngEntity1.setCdCategory("OBJECT_TYPE");
        codeMngEntity1.setCdId("OBJECT_TYPE_2");
        codeMngEntity1.setCdName("Tool");
        codeMngEntity1.setCdKey("base.common.code.object.tool");
        codeMngRepository.save(codeMngEntity1);

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setRoleCode("ADMIN");
        rolesEntity.setRoleName("admin");
        rolesEntity.setIsActive(ActiveStatus.ACTIVE);
        rolesEntity.setId(rolesRepository.save(rolesEntity).getId());

        ObjectsEntity objectsEntity = new ObjectsEntity();
        objectsEntity.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity.setCode("QLHT");
        objectsEntity.setName("Quản lý hệ thống");
        objectsEntity.setOrderBy(0L);
        objectsEntity.setIcons("circle-exclamation");
        objectsEntity.setType(codeMngEntity.getCdId());
        objectsEntity.setKey("base.menu.system.management");
        objectsEntity.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity.setIsStart(ActiveStatus.ACTIVE);
        objectsEntity.setUrl("/supper-admin/system-management/objects");
        objectsEntity.setId(objectsRepository.save(objectsEntity).getId());

        ObjectsEntity objectsEntity1 = new ObjectsEntity();
        objectsEntity1.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity1.setCode("QLHT_ROLE");
        objectsEntity1.setName("Quản lý phân quyền");
        objectsEntity1.setOrderBy(0L);
        objectsEntity1.setIcons("circle-exclamation");
        objectsEntity1.setType(codeMngEntity.getCdId());
        objectsEntity1.setKey("base.menu.system.author");
        objectsEntity1.setParentId(objectsEntity.getId());
        objectsEntity1.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity1.setType(codeMngEntity.getCdId());
        objectsEntity1.setIsStart(ActiveStatus.ACTIVE);
        objectsEntity1.setUrl("/supper-admin/system-management/roles");
        objectsEntity1.setId(objectsRepository.save(objectsEntity1).getId());

        ObjectsEntity objectsEntity2 = new ObjectsEntity();
        objectsEntity2.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity2.setCode("QLHT_USER");
        objectsEntity2.setName("Quản lý người dùng");
        objectsEntity2.setOrderBy(1L);
        objectsEntity2.setIcons("circle-exclamation");
        objectsEntity2.setKey("base.menu.system.user");
        objectsEntity2.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity2.setParentId(objectsEntity.getId());
        objectsEntity2.setType(codeMngEntity.getCdId());
        objectsEntity2.setIsStart(ActiveStatus.ACTIVE);
        objectsEntity2.setUrl("/supper-admin/system-management/users");
        objectsEntity2.setId(objectsRepository.save(objectsEntity2).getId());


        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setIsActive(ActiveStatus.ACTIVE);
        usersEntity.setUserName("admin");
        usersEntity.setPassword("admin");
        usersEntity.setFullName("admin");
        usersEntity.setEmail("admin");
        usersEntity.setId(usersRepository.save(usersEntity).getId());

        UserObjectEntity userObjectEntity = new UserObjectEntity();
        userObjectEntity.setObjectId(objectsEntity);
        userObjectEntity.setUserid(usersEntity);
        userObjectEntity.setIsActive(ActiveStatus.ACTIVE);
        userObjectRepository.save(userObjectEntity);

        UserObjectEntity userObjectEntity1 = new UserObjectEntity();
        userObjectEntity1.setObjectId(objectsEntity1);
        userObjectEntity1.setUserid(usersEntity);
        userObjectEntity1.setIsActive(ActiveStatus.ACTIVE);
        userObjectRepository.save(userObjectEntity1);

        UserObjectEntity userObjectEntity2 = new UserObjectEntity();
        userObjectEntity2.setObjectId(objectsEntity2);
        userObjectEntity2.setUserid(usersEntity);
        userObjectEntity2.setIsActive(ActiveStatus.ACTIVE);
        userObjectRepository.save(userObjectEntity2);

        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUserId(usersEntity);
        userRoleEntity.setRolesEntityId(rolesEntity);
        userRoleEntity.setIsActive(ActiveStatus.ACTIVE);
        userRoleRepository.save(userRoleEntity);

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DBGenerator.class);
        ctx.close();

        System.out.println("Hello world!!!");
    }

}
