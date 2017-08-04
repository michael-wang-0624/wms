package TTT;

import com.stylefeng.guns.common.persistence.model.LoginLog;
import com.stylefeng.guns.common.persistence.dao.LoginLogMapper;
import TTT.ILoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-03
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {
	
}
