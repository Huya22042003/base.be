package com.example.coreBaseTool;// package com.articlesprojectTool;

import com.example.corebase.entity.Objects;
import com.example.corebase.entity.Roles;
import com.example.corebase.entity.UserObject;
import com.example.corebase.entity.UserRole;
import com.example.corebase.entity.Users;
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
        Roles roles = new Roles();
        roles.setRoleCode("ADMIN");
        roles.setRoleName("admin");
        roles.setIsActive(ActiveStatus.ACTIVE);
        roles.setId(rolesRepository.save(roles).getId());

        Objects objects = new Objects();
        objects.setIsActive(ActiveStatus.ACTIVE);
        objects.setCode("QLHT");
        objects.setName("Quản lý hệ thống");
        objects.setOrderBy(0L);
        objects.setIcons("circle-exclamation");
        objects.setType(TypeObjects.NAV_BAR);
        objects.setId(objectsRepository.save(objects).getId());

        Objects objects1 = new Objects();
        objects1.setIsActive(ActiveStatus.ACTIVE);
        objects1.setCode("QLHT_ROLE");
        objects1.setName("Quản lý phân quyền");
        objects1.setOrderBy(0L);
        objects1.setIcons("circle-exclamation");
        objects1.setType(TypeObjects.NAV_BAR);
        objects1.setParentId(objects.getId());
        objects1.setId(objectsRepository.save(objects1).getId());

        Objects objects2 = new Objects();
        objects2.setIsActive(ActiveStatus.ACTIVE);
        objects2.setCode("QLHT_USER");
        objects2.setName("Quản lý người dùng");
        objects2.setOrderBy(0L);
        objects2.setIcons("circle-exclamation");
        objects2.setType(TypeObjects.NAV_BAR);
        objects2.setParentId(objects.getId());
        objects2.setId(objectsRepository.save(objects2).getId());


        Users users = new Users();
        users.setIsActive(ActiveStatus.ACTIVE);
        users.setUserName("admin");
        users.setPassword("admin");
        users.setFullName("admin");
        users.setEmail("admin");
        users.setId(usersRepository.save(users).getId());

        UserObject userObject = new UserObject();
        userObject.setObjectId(objects);
        userObject.setUserid(users);
        userObject.setIsActive(ActiveStatus.ACTIVE);
        userObjectRepository.save(userObject);

        UserObject userObject1 = new UserObject();
        userObject1.setObjectId(objects1);
        userObject1.setUserid(users);
        userObject1.setIsActive(ActiveStatus.ACTIVE);
        userObjectRepository.save(userObject1);

        UserObject userObject2 = new UserObject();
        userObject2.setObjectId(objects2);
        userObject2.setUserid(users);
        userObject2.setIsActive(ActiveStatus.ACTIVE);
        userObjectRepository.save(userObject2);

        UserRole userRole = new UserRole();
        userRole.setUserId(users);
        userRole.setRolesId(roles);
        userRole.setIsActive(ActiveStatus.ACTIVE);
        userRoleRepository.save(userRole);

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DBGenerator.class);
        ctx.close();

        System.out.println("Hello world!!!");
    }

}
