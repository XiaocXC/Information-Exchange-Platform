//登录验证的函数
public void login(String ID,String password,Stage stage){
        if(ID.length()==10){
            System.out.println("账号为学生");
            controller=new Student_Controller();
            int status=controller.LoginC(ID,password);
            if(status==1){
                System.out.println("学生登录成功！");
                if(remember_id.isSelected())
                    USERINFO.put(ID,password);
                else
                    USERINFO.put(ID,"");
                writeUSERINFO();
                Main_View main_view = new Main_View();
            }else if(status==0)
                showDialog(Alert.AlertType.ERROR,"失败","登录失败。账号或密码错误","ERROR:Fail to Login.Password or Account is Wrong!");
            else if(status==-1)
                showDialog(Alert.AlertType.ERROR,"失败","登录失败。该账号已经登录","ERROR:Fail to Login.This Account is Already Logined!");
            else if(status==-2)
                showDialog(Alert.AlertType.ERROR,"失败","出现异常，请重试","ERROR:Some Exceptions are Happened!Please Retry");
        }else if(ID.length()==6){
            System.out.println("账号为老师");
            controller=new Teacher_Controller();
            int status=controller.LoginC(ID);
            int status=controller.LoginC(ID,password);
            if(status==1){
                if(remember_id.isSelected())
                    USERINFO.put(ID,password);
                else
                    USERINFO.put(ID,"");
                writeUSERINFO();
                System.out.println("教师登录成功！");
                Main_View main_view = new Main_View();
                main_view.show(stag);
            }else if(status==0)
                showDialog(Alert.AlertType.ERROR,"失败","登录失败。账号或密码错误","ERROR:Fail to Login.Password or Account is wrong!");
            else if(status==-1)
                showDialog(Alert.AlertType.ERROR,"失败","登录失败。该账号已经登录","ERROR:Fail to Login.This Account is already logined!");
            else if(status==-2)
                showDialog(Alert.AlertType.ERROR,"失败","出现异常，请重试","ERROR:Some Exceptions are happened!Please Retry!");
        }else
            showDialog(Alert.AlertType.ERROR,"失败","账号非老师或学生账号","ERROR:Your Input isn't Effective Account.");
    }
