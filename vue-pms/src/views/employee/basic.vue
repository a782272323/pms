<template>
  <div class="app-container">
    <div class="filter-container">
      <!-- 搜索功能区域 -->
      <!-- 普通查询 -->
      <el-row :gutter="20">
        <el-col :span="24" :offset="0">
          <div>
            <el-form :inline="true">
              <el-form-item>
                <!-- todo 加蓝色边框做个笔记，还有这个页面涉及到不懂的也做个笔记 -->
                <el-input
                  placeholder="输入员工名称搜索"
                  style="width: 200px;border: 1px solid #409EFF;"
                  prefix-icon="el-icon-search"
                  maxlength="10"
                  show-word-limit
                />
              </el-form-item>
              <el-form-item>
                <el-button class="filter-item" type="primary" icon="el-icon-search">
                  搜索
                </el-button>
                <el-button :icon="showAdvanceSearchShow ? 'el-icon-caret-top' : 'el-icon-caret-bottom'" aria-hidden="true"
                           class="filter-item" type="primary" @click="showAdvanceSearchShow = !showAdvanceSearchShow">
                  高级搜索搜索
                </el-button>
                <el-button class="filter-item" icon="el-icon-plus" type="primary">
                  添加员工
                </el-button>
                <el-button class="filter-item" icon="el-icon-close" type="danger" plain>
                  批量删除
                </el-button>
              </el-form-item>
            </el-form>
            <!-- 高级搜索 -->
            <transition >
              <div v-show="showAdvanceSearchShow"
                   style="border: 1px solid #409EFF;border-radius: 5px;box-sizing: border-box;padding: 5px;margin-top: -22px;margin-bottom: 20px"
              >
                <el-row>
                  <el-col :span="5">
                    政治面貌:
                    <el-select placeholder="政治面貌" size="mini" style="width: 130px;">
                      <el-option >

                      </el-option>
                    </el-select>
                  </el-col>
                  <el-col :span="4">
                    民族:
                    <el-select placeholder="民族" size="mini" style="width: 130px;">
                      <el-option >

                      </el-option>
                    </el-select>
                  </el-col>
                  <el-col :span="4">
                    职位:
                    <el-select placeholder="职位" size="mini" style="width: 130px;">
                      <el-option >

                      </el-option>
                    </el-select>
                  </el-col>
                  <el-col :span="4">
                    职称:
                    <el-select placeholder="职称" size="mini" style="width: 130px;">
                      <el-option >

                      </el-option>
                    </el-select>
                  </el-col>
                  <el-col :span="7">
                    聘用形式:
                    <el-radio-group >
                      <el-radio label="劳动合同">劳动合同</el-radio>
                      <el-radio label="劳务合同">劳务合同</el-radio>
                    </el-radio-group>
                  </el-col>
                </el-row>
                <el-row style="margin-top: 10px;">
                  <el-col :span="5">
                    所属部门:
                    <el-popover
                      placement="right"
                      title="请选择部门"
                      width="200"
                      trigger="manual"
                      >
                      <el-tree default-expand-all ></el-tree>
                      <div slot="reference"
                           style="width: 130px;display: inline-flex;font-size: 13px;border: 1px solid #dedede;box-sizing: border-box;
                                height: 26px;border-radius: 5px;cursor: pointer;align-items: center;padding-left: 8px;margin-left: 3px"
                           ></div>
                    </el-popover>
                  </el-col>
                  <el-col :span="10">
                    入职日期:
                    <el-date-picker
                      type="daterange"
                      size="mini"
                      unlink-panels
                      value-format="yyyy-MM-dd"
                      range-separator="至"
                      start-placeholder="开始日期"
                      end-placeholder="离职日期"
                      />
                  </el-col>
                  <el-col :span="5" :offset="4">
                    <el-button size="mini">取消</el-button>
                    <el-button size="mini" icon="el-icon-search" type="primary">搜索</el-button>
                  </el-col>
                </el-row>
              </div>
            </transition>
          </div>
        </el-col>
      </el-row>
      <!-- /搜索功能区域 -->

      <!-- 表格区域 -->
      <el-table
        style="margin-top: 0px;width: 100%;border: 1px solid #409EFF;"
        border
        fit
        stripe
        highlight-current-row
      >
        <!-- 多选框实现批量删除 -->
        <el-table-column type="selection" width="50" align="center" />
        <el-table-column fixed label="姓名" sortable="custom" align="center" width="90">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="工号" sortable="custom" align="center" width="90">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="性别" sortable="custom" align="center" width="90">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="出生日期" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="身份证号码" sortable="custom" align="center" width="150">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="婚姻状况" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="民族" sortable="custom" align="center" width="90">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="籍贯" sortable="custom" align="center" width="90">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="政治面貌" sortable="custom" align="center" width="150">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="电子邮件" sortable="custom" align="center" width="180">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="电话号码" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="联系地址" sortable="custom" align="center" width="220">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="所属部门" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="职位" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="职称" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="聘用形式" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="最高学历" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="专业" sortable="custom" align="center" width="180">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="毕业院校" sortable="custom" align="center" width="150">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="入职日期" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="转正日期" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="合同起始日期" sortable="custom" align="center" width="130">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="合同截止日期" sortable="custom" align="center" width="130">
          <template slot-scope="scope">
            <span></span>
          </template>
        </el-table-column>
        <el-table-column label="合同期限" sortable="custom" align="center" width="110">
          <template slot-scope="scope">
            <el-tag></el-tag>
            年
          </template>
        </el-table-column>
        <el-table-column fixed="right" label="操作" align="center" width="230" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button style="padding: 3px" size="mini">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- /表格区域 -->

      <!-- 分页区域 -->
      <el-row :gutter="20">
        <el-col :span="10" :offset="6">
          <div class="block">
            <el-pagination
              style="margin-top: 30px"
              layout="total sizes, prev, pager, next, jumper"
            />
          </div>
        </el-col>
      </el-row>
      <!-- /分页区域 -->

    </div>
  </div>
</template>

<script>
export default {
  name: 'EmployeeBasic',
  data() {
    return {
      // 用于显示与隐藏高级搜索
      showAdvanceSearchShow: false
    }
  }
}
</script>

<style scoped>

</style>
