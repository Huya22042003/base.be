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
    private PremiumTypesRepository premiumTypesRepository;

    @Autowired
    private UserPremiumRepository userPremiumRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CodeMngRepository codeMngRepository;

    @Override
    public void run(String... args) throws Exception {
        // code mng
        CodeMngEntity codeMngEntity = new CodeMngEntity();
        codeMngEntity.setCdCategory("OBJECT_TYPE");
        codeMngEntity.setCdId("OBJECT_TYPE_1");
        codeMngEntity.setCdName("Menu");
        codeMngEntity.setCdKey("base.common.code.object.menu");
        codeMngRepository.save(codeMngEntity);

        CodeMngEntity codeMngEntity1 = new CodeMngEntity();
        codeMngEntity1.setCdCategory("OBJECT_TYPE");
        codeMngEntity1.setCdId("OBJECT_TYPE_2");
        codeMngEntity1.setCdName("Tool");
        codeMngEntity1.setCdKey("base.common.code.object.tool");
        codeMngRepository.save(codeMngEntity1);

        CodeMngEntity codeMngEntity2 = new CodeMngEntity();
        codeMngEntity.setCdCategory("OBJECT_TYPE");
        codeMngEntity.setCdId("OBJECT_TYPE_3");
        codeMngEntity.setCdName("Api");
        codeMngEntity.setCdKey("base.common.code.object.api");
        codeMngRepository.save(codeMngEntity2);

        CodeMngEntity codeMngEntity3 = new CodeMngEntity();
        codeMngEntity3.setCdCategory("CONDITION_TYPE");
        codeMngEntity3.setCdId("CONDITION_TYPE_1");
        codeMngEntity3.setCdName("Không có điều kiện");
        codeMngEntity3.setCdKey("base.common.code.condition.no_condition");
        codeMngRepository.save(codeMngEntity3);

        CodeMngEntity codeMngEntity4 = new CodeMngEntity();
        codeMngEntity4.setCdCategory("CONDITION_TYPE");
        codeMngEntity4.setCdId("CONDITION_TYPE_2");
        codeMngEntity4.setCdName("Lượt dùng tối đa");
        codeMngEntity4.setCdKey("base.common.code.condition.use_max");
        codeMngRepository.save(codeMngEntity4);

        CodeMngEntity codeMngEntity5 = new CodeMngEntity();
        codeMngEntity5.setCdCategory("CONDITION_TYPE");
        codeMngEntity5.setCdId("CONDITION_TYPE_3");
        codeMngEntity5.setCdName("Thời gian sử dụng");
        codeMngEntity5.setCdKey("base.common.code.condition.use_time");
        codeMngRepository.save(codeMngEntity5);

        CodeMngEntity codeMngEntity6 = new CodeMngEntity();
        codeMngEntity6.setCdCategory("ACTIVE_TYPE");
        codeMngEntity6.setCdId("ACTIVE_TYPE_1");
        codeMngEntity6.setCdName("Hoạt động");
        codeMngEntity6.setCdKey("base.common.code.active.active");
        codeMngRepository.save(codeMngEntity6);

        CodeMngEntity codeMngEntity7 = new CodeMngEntity();
        codeMngEntity7.setCdCategory("ACTIVE_TYPE");
        codeMngEntity7.setCdId("ACTIVE_TYPE_2");
        codeMngEntity7.setCdName("Không hoạt động");
        codeMngEntity7.setCdKey("base.common.code.active.unactive");
        codeMngRepository.save(codeMngEntity7);

        CodeMngEntity codeMngEntity8 = new CodeMngEntity();
        codeMngEntity8.setCdCategory("PREMIUM_TYPE");
        codeMngEntity8.setCdId("PREMIUM_TYPE_1");
        codeMngEntity8.setCdName("Miễn phí");
        codeMngEntity8.setCdKey("base.common.code.premium.free");
        codeMngRepository.save(codeMngEntity8);

        CodeMngEntity codeMngEntity9 = new CodeMngEntity();
        codeMngEntity9.setCdCategory("PREMIUM_TYPE");
        codeMngEntity9.setCdId("PREMIUM_TYPE_2");
        codeMngEntity9.setCdName("Trả phí");
        codeMngEntity9.setCdKey("base.common.code.premium.payFee");
        codeMngRepository.save(codeMngEntity9);

        CodeMngEntity codeMngEntity10 = new CodeMngEntity();
        codeMngEntity10.setCdCategory("DEFAULT_TYPE");
        codeMngEntity10.setCdId("DEFAULT_TYPE_1");
        codeMngEntity10.setCdName("Mặc định");
        codeMngEntity10.setCdKey("base.common.code.default.default");
        codeMngRepository.save(codeMngEntity10);

        CodeMngEntity codeMngEntity11 = new CodeMngEntity();
        codeMngEntity11.setCdCategory("DEFAULT_TYPE");
        codeMngEntity11.setCdId("DEFAULT_TYPE_2");
        codeMngEntity11.setCdName("Lớp thường");
        codeMngEntity11.setCdKey("base.common.code.default.custom");
        codeMngRepository.save(codeMngEntity11);

        // ROLE
        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setRoleName("Supper Admin");
        rolesEntity.setRoleCode("SUPPER_ADMIN");
        rolesRepository.save(rolesEntity);

        RolesEntity rolesEntity1 = new RolesEntity();
        rolesEntity1.setRoleName("Admin");
        rolesEntity1.setRoleCode("ADMIN");
        rolesRepository.save(rolesEntity1);

        RolesEntity rolesEntity2 = new RolesEntity();
        rolesEntity2.setRoleName("Staff");
        rolesEntity2.setRoleCode("STAFF");
        rolesRepository.save(rolesEntity2);


    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DBGenerator.class);
        ctx.close();

        System.out.println("Hello world!!!");
    }

}
