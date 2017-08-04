package TTT;

import com.stylefeng.guns.common.persistence.model.Relation;
import com.stylefeng.guns.common.persistence.dao.RelationMapper;
import TTT.IRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-03
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {
	
}
