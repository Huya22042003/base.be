package com.example.coreBaseTool;// package com.articlesprojectTool;

import com.example.corebase.entity.ObjectsEntity;
import com.example.corebase.entity.RolesEntity;
import com.example.corebase.entity.UserObjectEntity;
import com.example.corebase.entity.UserRoleEntity;
import com.example.corebase.entity.UsersEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.constant.TypeObjects;
import com.example.corebase.repository.ObjectPremiumRepository;
import com.example.corebase.repository.ObjectsRepository;
import com.example.corebase.repository.PremiumTypesRepository;
import com.example.corebase.repository.RoleObjectRepository;
import com.example.corebase.repository.RolesRepository;
import com.example.corebase.repository.UserObjectRepository;
import com.example.corebase.repository.UserPremiumRepository;
import com.example.corebase.repository.UserRoleRepository;
import com.example.corebase.repository.UsersRepository;
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

    @Override
    public void run(String... args) throws Exception {
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
        objectsEntity.setType(TypeObjects.NAV_BAR);
        objectsEntity.setKey("base.menu.system.management");
        objectsEntity.setId(objectsRepository.save(objectsEntity).getId());

        ObjectsEntity objectsEntity1 = new ObjectsEntity();
        objectsEntity1.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity1.setCode("QLHT_ROLE");
        objectsEntity1.setName("Quản lý phân quyền");
        objectsEntity1.setOrderBy(0L);
        objectsEntity1.setIcons("circle-exclamation");
        objectsEntity1.setType(TypeObjects.NAV_BAR);
        objectsEntity1.setKey("base.menu.system.author");
        objectsEntity1.setParentId(objectsEntity.getId());
        objectsEntity1.setId(objectsRepository.save(objectsEntity1).getId());

        ObjectsEntity objectsEntity2 = new ObjectsEntity();
        objectsEntity2.setIsActive(ActiveStatus.ACTIVE);
        objectsEntity2.setCode("QLHT_USER");
        objectsEntity2.setName("Quản lý người dùng");
        objectsEntity2.setOrderBy(0L);
        objectsEntity2.setIcons("circle-exclamation");
        objectsEntity2.setKey("base.menu.system.user");
        objectsEntity2.setType(TypeObjects.NAV_BAR);
        objectsEntity2.setParentId(objectsEntity.getId());
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
