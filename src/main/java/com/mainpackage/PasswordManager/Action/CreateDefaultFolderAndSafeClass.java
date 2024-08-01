package com.mainpackage.PasswordManager.Action;

import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.Util.UserUtilService;
import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.model.Folder;
import com.mainpackage.PasswordManager.model.Safe;
import com.mainpackage.PasswordManager.service.FolderService;
import com.mainpackage.PasswordManager.service.RegisterService;
import com.mainpackage.PasswordManager.service.SafeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDefaultFolderAndSafeClass {
    @Autowired
    private SafeServiceImp safeServiceImp;
    @Autowired
    private FolderService folderService;
    UserUtilService userUtilService=new UserUtilService();
    @Autowired
    private RegisterService registerService;
    public void createDefaultUserAssets(Long id){
        String defaultSafeName="main";
        Safe defaultSafe=new Safe();
        defaultSafe.setUserid(id);
        defaultSafe.setName(defaultSafeName);
        safeServiceImp.createSafe(defaultSafe);
        String defaultFolderName="none";
        Folder defaultFolder=new Folder();
        defaultFolder.setSafeid(defaultSafe.getSafeid());
        defaultFolder.setName(defaultFolderName);
        folderService.save(defaultFolder);
    }

    public void  execute(CustomUser customUser){
        CustomUser user=new CustomUser();
        customUser.setUserid(user.getUserid());
        registerService.saveUser(customUser);
        userUtilService.SetUserParameters(customUser);
        Long id= UserUtil.getId();
        System.out.println(id);
        createDefaultUserAssets(id);

    }
}
